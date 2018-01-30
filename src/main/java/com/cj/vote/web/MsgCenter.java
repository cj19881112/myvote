package com.cj.vote.web;

import com.cj.vote.domain.Craft;
import com.cj.vote.domain.Message;
import com.cj.vote.domain.Sense;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;

import javax.annotation.PostConstruct;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

@Component
@ServerEndpoint("/ws")
public class MsgCenter {
    private final Logger logger = Logger.getLogger(this.getClass());
    private static final List<Session> sessionList = new LinkedList<>();
    private static final List<Session> sessionListScreenAndControl = new LinkedList<>();
    private Gson gson = new GsonBuilder().create();

    @Autowired
    private Sender sender;

    private Map<Long, Integer> maxVoting = new HashMap<>();

    @OnOpen
    public void open(Session session) {
    }

    @OnClose
    public void close(Session session) {
        sessionListScreenAndControl.remove(session);
        sessionList.remove(session);
    }

    @OnMessage
    public void msg(String msgStr, Session session) {
        Map<String, String> map = gson.fromJson(msgStr, Map.class);
        String type = map.get("type");
        if (type.equals("vote")) {
        } else {
            sessionListScreenAndControl.add(session);
        }
        sessionList.add(session);
    }

    public synchronized void broadCast(Message msg) {
        if (msg.getCode().equals(Message.VOTE)) {
            Sense sense = (Sense) msg.getData();
            int total = 0;
            for (Craft c : sense.getCraftList()) {
                total += c.getNormalVote();
                total += c.getExpertVote();
            }

            Integer max = maxVoting.get(sense.getSenseId());
            if (null == max) {
                max = 0;
            }
            if (total > max) {
                maxVoting.put(sense.getSenseId(), total);
                sender.sendNotify(msg, sessionListScreenAndControl);
            }
        } else {
            sender.sendNotify(msg, sessionList);
        }
    }
}

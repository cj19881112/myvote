package com.cj.vote.web;

import com.cj.vote.domain.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
@ServerEndpoint("/ws")
public class MsgCenter {
    protected final Logger logger = Logger.getLogger(this.getClass());
    private static final List<Session> sessionList = new LinkedList<>();
    private Gson gson = new GsonBuilder().create();

    @OnOpen
    public void open(Session session) {
        logger.info("客户端接入");
        sessionList.add(session);
    }

    @OnClose
    public void close(Session session) {
        sessionList.remove(session);
    }

    @OnMessage
    public void msg(String msg, Session session) {
        logger.info("客户端发来信息:" + msg);
    }

    public void broadCast(Message msg) {
        for (Session s : sessionList) {
            try {
                s.getBasicRemote().sendText(gson.toJson(msg));
            } catch (IOException e) {
                e.printStackTrace();
                logger.trace("发送消息失败");
            }
        }
    }
}

package com.cj.vote.web;

import com.cj.vote.domain.Craft;
import com.cj.vote.domain.Message;
import com.cj.vote.domain.Sense;
import com.cj.vote.utils.G;
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

    @Autowired
    private Sender sender;

    @OnOpen
    public void open(Session session) {
        logger.info("接收到客户端的连接");
        sessionList.add(session);
    }

    @OnClose
    public void close(Session session) {
        logger.info("客户端断开连接");
        sessionList.remove(session);
    }

    @OnMessage
    public void onMessage(String msgStr, Session session) {
        // 客户端心跳
    }

    public synchronized void broadCast(Message msg) {
        logger.info("发送消息:" + msg.getCode() + ",给" + sessionList.size() + "个客户端");
        sender.sendNotify(msg, sessionList);
    }
}

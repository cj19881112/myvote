package com.cj.vote.web;

import com.cj.vote.domain.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.List;

@Component
public class Sender {
    private Gson gson = new GsonBuilder().create();

    @Async
    public void sendNotify(Message msg, List<Session> sessionListScreenAndControl) {
        for (Session s : sessionListScreenAndControl) {
            try {
                s.getBasicRemote().sendText(gson.toJson(msg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
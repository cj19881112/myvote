package com.cj.vote.web;

import com.cj.vote.domain.Message;
import com.cj.vote.domain.Sense;
import com.cj.vote.service.SenseService;
import com.cj.vote.service.VoteService;
import com.cj.vote.utils.AlreadyVoteException;
import com.cj.vote.utils.InvalidCraftException;
import com.cj.vote.utils.InvalidSenseException;
import com.cj.vote.utils.Ret;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
@Aspect
public class VoteController {
    @Autowired
    private SenseService senseService;

    @Autowired
    private MsgCenter msgCenter;

    @Autowired
    private VoteService voteService;

    public String createUID(String uid, HttpServletResponse resp) {
        if (StringUtils.isEmpty(uid)) {
            uid = UUID.randomUUID().toString();
            Cookie c = new Cookie("myuid", uid);
            c.setPath("/");
            c.setMaxAge(60*60*60);
            resp.addCookie(c);
        }
        return uid;
    }

    @RequestMapping("/sign")
    public @ResponseBody
    Ret<String> signUp(
            @CookieValue(name = "myuid", required = false) String uid,
            HttpServletResponse resp) {
        uid = createUID(uid, resp);
        return Ret.ok(uid);
    }

    @RequestMapping("/currentSense")
    public @ResponseBody
    Ret<Sense> currentSense(
            @CookieValue(name = "myuid", required = false) String uid,
            HttpServletResponse resp) {
        uid = createUID(uid, resp);
        try {
            return Ret.ok(senseService.currentSense(uid));
        } catch (InvalidSenseException e) {
            return Ret.err("无效的场景，不存在当前场景");
        }
    }

    @RequestMapping("/vote/{craftId}/{voteType}")
    public @ResponseBody
    Ret<Void> vote(
            @CookieValue(name = "myuid", required = false) String uid,
            @PathVariable("craftId") Long craftId,
            @PathVariable("voteType") String voteType,
            HttpServletResponse resp) {
        uid = createUID(uid, resp);
        try {
            voteService.vote(craftId, uid, voteType);
            msgCenter.broadCast(Message.vote(senseService.currentSense()));
        } catch (InvalidCraftException e) {
            return Ret.err("无效的作品编号");
        } catch (InvalidSenseException e) {
            return Ret.err("无效的场景或者场景状态不正确");
        } catch (AlreadyVoteException e) {
            return Ret.err("您已经投票过了，不要重复投票");
        }
        return Ret.ok();
    }

    @RequestMapping("/stop/{senseId}")
    public @ResponseBody
    Ret<Void> stop(
            @PathVariable("senseId") Long senseId) {
        try {
            senseService.stop(senseId);
            msgCenter.broadCast(Message.startStop(senseService.currentSense()));
            return Ret.ok();
        } catch (InvalidSenseException e) {
            return Ret.err("无效的场景编号");
        }
    }

    @RequestMapping("/start/{senseId}")
    public @ResponseBody
    Ret<Void> start(
            @PathVariable("senseId") Long senseId) {
        try {
            senseService.start(senseId);
            msgCenter.broadCast(Message.startStop(senseService.currentSense()));
            return Ret.ok();
        } catch (InvalidSenseException e) {
            return Ret.err("无效的场景编号");
        }
    }


    @RequestMapping("/nextSense")
    public @ResponseBody
    Ret<Void> nextSense() {
        try {
            senseService.nextSense();
            msgCenter.broadCast(Message.switchSense(senseService.currentSense()));
            return Ret.ok();
        } catch (InvalidSenseException e) {
            return Ret.err("无效的场景编号");
        }
    }

    @RequestMapping("/prevSense")
    public @ResponseBody
    Ret<Void> prevSense() {
        try {
            senseService.prevSense();
            msgCenter.broadCast(Message.switchSense(senseService.currentSense()));
            return Ret.ok();
        } catch (InvalidSenseException e) {
            return Ret.err("无效的场景编号");
        }
    }

    @RequestMapping("/allSense")
    public @ResponseBody
    Ret<List<Sense>> allSense() {
        return Ret.ok(senseService.allSense());
    }
}

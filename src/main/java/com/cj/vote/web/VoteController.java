package com.cj.vote.web;

import com.cj.vote.domain.Message;
import com.cj.vote.domain.Sense;
import com.cj.vote.service.SenseService;
import com.cj.vote.service.VoteService;
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
import java.util.UUID;

@Controller
@Aspect
public class VoteController {
    @Autowired
    private SenseService senseService;

    @Autowired
    private VoteService voteService;

    public static final String UID_NAME = "my_uid";

    public String createUID(String uid, HttpServletResponse resp) {
        if (StringUtils.isEmpty(uid)) {
            uid = UUID.randomUUID().toString();
            Cookie c = new Cookie(UID_NAME, uid);
            c.setPath("/");
            c.setMaxAge(60 * 60 * 60);
            resp.addCookie(c);
        }
        return uid;
    }

    /**
     * 获取用户的唯一码，用户开始任何操作前，先执行本操作
     *
     * @param uid
     * @param resp
     * @return
     */
    @RequestMapping("/sign")
    public @ResponseBody
    Ret<String> signUp(@CookieValue(name = UID_NAME, required = false) String uid, HttpServletResponse resp) {
        uid = createUID(uid, resp);
        return Ret.ok(uid);
    }

    /**
     * 获取当前的场景
     *
     * @param uid
     * @return
     */
    @RequestMapping("/currentSense")
    public @ResponseBody
    Ret<Sense> currentSense(@CookieValue(name = UID_NAME) String uid) {
        return Ret.ok(senseService.currentSense(uid));
    }

    /**
     * 投票
     *
     * @param uid      用户id
     * @param craftId  作品id
     * @param voteType 投票类型: 0: 普通 1：专家1 2：专家2
     * @return
     */
    @RequestMapping("/vote/{craftId}/{voteType}")
    public @ResponseBody
    Ret<Void> vote(
            @CookieValue(name = UID_NAME) String uid,
            @PathVariable("craftId") Long craftId,
            @PathVariable("voteType") String voteType) {
        voteService.vote(craftId, uid, voteType);
        return Ret.ok();
    }

    /**
     * 停止投票
     *
     * @param senseId
     * @return
     */
    @RequestMapping("/stop/{senseId}")
    public @ResponseBody
    Ret<Void> stop(@PathVariable("senseId") Long senseId) {
        senseService.stop(senseId);
        return Ret.ok();
    }

    /**
     * 开始投票
     * @param senseId
     * @return
     */
    @RequestMapping("/start/{senseId}")
    public @ResponseBody
    Ret<Void> start(
            @PathVariable("senseId") Long senseId) {
        senseService.start(senseId);
        return Ret.ok();
    }

    /**
     * 下一场景
     * @return
     */
    @RequestMapping("/nextSense")
    public @ResponseBody
    Ret<Void> nextSense() {
        senseService.nextSense();
        return Ret.ok();
    }

    /**
     * 前一场景
     * @return
     */
    @RequestMapping("/prevSense")
    public @ResponseBody
    Ret<Void> prevSense() {
        senseService.prevSense();
        return Ret.ok();
    }
}

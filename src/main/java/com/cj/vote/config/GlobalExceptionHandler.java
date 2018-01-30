package com.cj.vote.config;

import com.cj.vote.utils.G;
import com.cj.vote.utils.Ret;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    /**
     * 全局异常处理
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Ret<Void> allExceptionHandler(HttpServletRequest request,
                                      Exception e) throws Exception {
        logger.trace("发生异常：" + e.getMessage(), e);
        return Ret.err(e.getMessage());
    }
}

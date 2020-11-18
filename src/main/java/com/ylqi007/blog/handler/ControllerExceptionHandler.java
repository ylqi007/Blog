package com.ylqi007.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice       // 拦截所有带有 @Controller 注解的控制器
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()); // 记录日志

    @ExceptionHandler(Exception.class)  // 可做异常处理
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception{
        logger.error("Request URL: {}. Exception: {}", request.getRequestURL(), e);

        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");  // 返回到哪个页面
        return mv;
    }
}

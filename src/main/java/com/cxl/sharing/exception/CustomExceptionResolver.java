package com.cxl.sharing.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常
 */
@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        Map<String, Object> map = new HashMap<>();
        map.put("status", 500);
        map.put("msg", "操作失败!");
        mv.addAllObjects(map);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("xxxxx@qq.com");
        message.setTo("xxxxx@qq.com");
        message.setSubject("主题:异常");
        message.setText(String.valueOf(map));

        javaMailSender.send(message);
        return mv;
    }
}

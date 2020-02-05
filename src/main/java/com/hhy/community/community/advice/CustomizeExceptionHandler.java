package com.hhy.community.community.advice;

import com.hhy.community.community.exception.CustomizeException;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hhy1997
 * 2020/2/5
 */
@ControllerAdvice
public class CustomizeExceptionHandler{
    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(HttpServletRequest request, Throwable ex,
                                           Model model) {
        if (ex instanceof CustomizeException){
            model.addAttribute("message",ex.getMessage());
        }else {
            model.addAttribute("message" , "服务出错了...");
        }
        return new ModelAndView("error");
    }
}

package com.hhy.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hhy1997
 * 2020/1/23
 */
@Controller
public class PublishController {
    @GetMapping("publish")
    public String publish(){
        return "publish";
    }
}

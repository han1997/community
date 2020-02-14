package com.hhy.community.community.controller;

import com.hhy.community.community.dto.NotificationDTO;
import com.hhy.community.community.enums.NotificationTypeEnum;
import com.hhy.community.community.model.User;
import com.hhy.community.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hhy1997
 * 2020/2/6
 */
@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping(value = "/notification/{id}")
    public String notification(@PathVariable(name = "id") Long id,
                               HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        NotificationDTO notificationDTO = notificationService.read(id, user);
        if (notificationDTO.getType() == NotificationTypeEnum.REPLY_QUESTION.getType()
                || notificationDTO.getType() == NotificationTypeEnum.REPLY_COMMENT.getType()){

            return "redirect:/question/" + notificationDTO.getOuterId();
        }else {
            return "redirect:/";
        }
    }
}

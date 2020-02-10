package com.hhy.community.community.controller;

import com.hhy.community.community.dto.CommentDTO;
import com.hhy.community.community.dto.QuestionDTO;
import com.hhy.community.community.enums.CommentTypeEnum;
import com.hhy.community.community.service.CommentService;
import com.hhy.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author hhy1997
 * 2020/2/3
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        List<CommentDTO> commentDTO = commentService.ListByTargetId(id, CommentTypeEnum.QUESTION);
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comment",commentDTO);
        return "question";
    }
}

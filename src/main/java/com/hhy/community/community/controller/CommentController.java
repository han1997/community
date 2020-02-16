package com.hhy.community.community.controller;

import com.hhy.community.community.dto.CommentCreateDTO;
import com.hhy.community.community.dto.CommentDTO;
import com.hhy.community.community.dto.ResultDTO;
import com.hhy.community.community.enums.CommentTypeEnum;
import com.hhy.community.community.exception.CustomizeErrorCode;
import com.hhy.community.community.model.Comment;
import com.hhy.community.community.model.User;
import com.hhy.community.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hhy1997
 * 2020/2/6
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())){
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModeified(comment.getGmtCreate());
        comment.setCommentator(commentCreateDTO.getCommentAtor());
        comment.setLikeCount(0L);
        comment.setCommentator(user.getId());
        commentService.createOrUpdate(comment,user);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}",method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id){
        List<CommentDTO> commentDTOS = commentService.ListByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
    @ResponseBody
    @RequestMapping(value = "/comment/incLike/{id}",method = RequestMethod.GET)
    public String incLike(@PathVariable(name = "id") Long id){
        commentService.incLike(id);
        return "success";
    }
}

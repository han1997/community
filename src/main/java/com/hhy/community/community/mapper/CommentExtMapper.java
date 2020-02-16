package com.hhy.community.community.mapper;

import com.hhy.community.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
    int incLike(Comment comment);
}
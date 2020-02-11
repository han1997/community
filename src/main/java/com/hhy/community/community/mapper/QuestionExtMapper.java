package com.hhy.community.community.mapper;

import com.hhy.community.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);

    int incCommentCount(Question question);

    List<Question> selectRelated(Question question);
}
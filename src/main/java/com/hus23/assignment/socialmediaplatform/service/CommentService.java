package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.Comments;

import java.util.List;

public interface CommentService {

    public Comments savecomment(Comments comments);

    public List<Comments> fetchCommentList();
}

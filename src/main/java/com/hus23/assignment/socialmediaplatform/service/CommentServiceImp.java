package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.Comments;
import com.hus23.assignment.socialmediaplatform.repository.CommentRepository;
import com.hus23.assignment.socialmediaplatform.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentRepository commentrepository;


    @Override
    public Comments savecomment(Comments comments) {
        return commentrepository.save(comments);
    }

    @Override
    public List<Comments> fetchCommentList() {
        return commentrepository.findAll();
    }
}

package com.hus23.assignment.socialmediaplatform.controller;

import com.hus23.assignment.socialmediaplatform.entity.Comments;
import com.hus23.assignment.socialmediaplatform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentservice;
    @PostMapping("/comments")
    public Comments savecomment(@RequestBody Comments comments){
        return commentservice.savecomment(comments);
    }

    @GetMapping("/comments")
    public List<Comments> fetchCommentList(){
          return commentservice.fetchCommentList();
    }
}

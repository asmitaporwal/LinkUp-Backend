package com.hus23.assignment.socialmediaplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    private String commentText;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Comments(Long commentId, String commentText) {
        this.commentId = commentId;
        this.commentText = commentText;
    }

    public Comments() {
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentId=" + commentId +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}

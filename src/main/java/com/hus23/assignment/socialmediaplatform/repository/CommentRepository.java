package com.hus23.assignment.socialmediaplatform.repository;

import com.hus23.assignment.socialmediaplatform.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long > {
}

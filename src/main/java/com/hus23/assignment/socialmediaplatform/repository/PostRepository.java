package com.hus23.assignment.socialmediaplatform.repository;

import com.hus23.assignment.socialmediaplatform.entity.Posts;
import com.hus23.assignment.socialmediaplatform.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Posts,Long> {

    public Posts findByLocation(String location);
    @Query("SELECT ud FROM Posts ud WHERE CONCAT(ud.location) LIKE %?1%")
    public List<Posts> search(String keyword);
}

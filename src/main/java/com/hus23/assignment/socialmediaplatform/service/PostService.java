package com.hus23.assignment.socialmediaplatform.service;
import com.hus23.assignment.socialmediaplatform.entity.Posts;

import java.util.List;

public interface PostService {
   public Posts saveposts(Posts posts);

    public List<Posts> fetchalltheposts();

    public Posts fetchpostbyid(Long id);

    public void deletepostbyid(Long id);

    public void deleteallpost();

    public Posts updateposts(Long id, Posts posts);

    public List<Posts> search(String location);
}

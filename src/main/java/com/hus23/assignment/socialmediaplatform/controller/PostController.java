package com.hus23.assignment.socialmediaplatform.controller;
import com.hus23.assignment.socialmediaplatform.entity.Posts;
import com.hus23.assignment.socialmediaplatform.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postservice;
    @PostMapping("/posts")
    public Posts savepost(@RequestBody Posts posts){
        return postservice.saveposts(posts);
    }

    @GetMapping("/posts")
    public List<Posts> fetchalltheposts(){
         return postservice.fetchalltheposts();
    }

    @GetMapping("/posts/{id}")
    public Posts fetchpostsbyid(@PathVariable("id") Long id){
       return postservice.fetchpostbyid(id);
 }
    @DeleteMapping("/posts/{id}")
    public String deletepostbyid(@PathVariable("id")Long id){
          postservice.deletepostbyid(id);
          return "post deleted successfully";
    }

    @DeleteMapping("/posts")
    public String deleteallpost(){
        postservice.deleteallpost();
        return "All the post deleted";
    }
    @PutMapping("/posts/{id}")
    public Posts updatepost(@PathVariable("id") Long id,@RequestBody Posts posts){
       return postservice.updateposts(id,posts);
    }

    @GetMapping("/location/{location}")
    public List<Posts> postbylocation(@PathVariable("location") String location){
         return postservice.search(location);
    }


}

package com.hus23.assignment.socialmediaplatform.controller;
import com.hus23.assignment.socialmediaplatform.entity.Login;
import com.hus23.assignment.socialmediaplatform.entity.Posts;
import com.hus23.assignment.socialmediaplatform.entity.UserDetails;
import com.hus23.assignment.socialmediaplatform.service.UserDetailsService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    private UserDetailsService service;
    @PostMapping("/userdetails")
    public ResponseEntity savedetails(@RequestBody UserDetails userdetails){
        if(userdetails.getUsername()!=null){
            return ResponseEntity.ok().body(service.saveUserDetails(userdetails));
        }else{
            return ResponseEntity.status(408).body("Enter valid user details");
        }
    }

    @PostMapping("/login")
    public ResponseEntity auth(@RequestBody Login login){
        if(service.fetchuserbyusernam(login.getUsername()).get().getPassword().equals(login.getPassword())){
            return ResponseEntity.ok().body(service.fetchuserbyusernam(login.getUsername()).get());
        }else{
            return ResponseEntity.status(401).body("Enter valid credentials");
        }
    }
    @GetMapping("/userdetails")
    public List<UserDetails> fetchUserList(){
        return service.fetchUserList();
    }

    @GetMapping("/userdetails/{id}")
    public UserDetails fetchuserdetailbyid(@PathVariable("id") Long uid){
        return service.fetchuserdetailbyid(uid);
    }

    @DeleteMapping("/userdetails/{id}")
    public String deleteuser(@PathVariable("id") Long uid){
        service.deleteuser(uid);
        return "User account deleted successfully";
    }

    @PatchMapping("/userdetails/{id}")
    public UserDetails updateuserdetails(@PathVariable("id") Long uid,@RequestBody UserDetails userdetails){

        return service.updateuserdetails(uid,userdetails);
    }

    @PostMapping("/search")
    public List<UserDetails> search(@RequestParam String keyword){
        return service.search(keyword);
    }

}

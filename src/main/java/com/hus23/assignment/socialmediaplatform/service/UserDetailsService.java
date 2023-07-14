package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService {
    public UserDetails saveUserDetails(UserDetails userdetails);
    public Optional<UserDetails> fetchuserbyusernam(String username);

    public List<UserDetails> search(String keyword);

    public List<UserDetails> fetchUserList();

    public UserDetails fetchuserdetailbyid(Long uid);

    public void deleteuser(Long uid);

    public UserDetails updateuserdetails(Long uid, UserDetails userdetails);


}

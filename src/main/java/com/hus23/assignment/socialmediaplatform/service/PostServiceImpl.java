package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.Posts;
import com.hus23.assignment.socialmediaplatform.repository.PostRepository;
import com.hus23.assignment.socialmediaplatform.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postrepository;

    @Autowired
    private UserDetailsRepository userrepo;

    @Override
    public Posts saveposts(Posts posts) {
        posts.setDate(LocalDate.now());
        posts.setTime(LocalTime.now());
        posts.setUser(userrepo.findById(posts.getUser().getUid()).get());
        return postrepository.save(posts);
    }

    @Override
    public List<Posts> fetchalltheposts() {
        return postrepository.findAll();
    }

    @Override
    public Posts fetchpostbyid(Long id) {
        return postrepository.findById(id).get();
    }

    @Override
    public void deletepostbyid(Long id) {
        postrepository.deleteById(id);
    }

    @Override
    public Posts updateposts(Long id, Posts posts) {
        Posts postDB=postrepository.findById(id).get();

        if(Objects.nonNull(posts.getText()) &&
                !"".equalsIgnoreCase(posts.getText())){
            postDB.setText(posts.getText());
        }
        if(Objects.nonNull(posts.getLocation()) &&
                !"".equalsIgnoreCase(posts.getLocation())){
            postDB.setLocation(posts.getLocation());
        }

        postDB.setDate(LocalDate.now());
        postDB.setTime(LocalTime.now());

        return postrepository.save(postDB);
    }

    @Override
    public List<Posts> search(String location) {
        return postrepository.search(location);
    }

    @Override
    public void deleteallpost() {
          postrepository.deleteAll();
    }
}

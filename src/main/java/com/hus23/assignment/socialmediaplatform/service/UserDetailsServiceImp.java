package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.UserDetails;
import com.hus23.assignment.socialmediaplatform.repository.UserDetailsRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userdetailsrepository;

    Logger logger= Logger.getLogger("UserDetailsServiceImp.class");
    @Override
    public UserDetails saveUserDetails(UserDetails userdetails) {
        UserDetails obj=null;
        try{
            obj=userdetailsrepository.save(userdetails);
            logger.info("Created user "+obj.toString());
        }catch(Exception e){
            logger.info("Exception while creating the user "+e.getMessage());
            e.printStackTrace();
        }finally {
            return obj;
        }
    }

    @Override
    public Optional<UserDetails> fetchuserbyusernam(String username) {
        Optional<UserDetails> obj=null;
        try{
            obj=userdetailsrepository.findByUsername(username);
            logger.info("Getting the username "+obj.toString());
        }catch(Exception e){
            logger.info("Exception while getting the name"+e.getMessage());
            e.printStackTrace();
        }finally {
            return obj;
        }

    }

    @Override
    public List<UserDetails> search(String keyword) {
        List<UserDetails> obj=null;
        try{
            obj=userdetailsrepository.search(keyword);
            logger.info("Searching the keyword "+obj.toString());
        }catch(Exception e){
            logger.info("Exception while searching the given keyword "+e.getMessage());
            e.printStackTrace();
        }finally {
            return obj;
        }

    }

    @Override
    public List<UserDetails> fetchUserList() {
        List<UserDetails> obj=null;
        try{
            obj=userdetailsrepository.findAll();
            logger.info("Fetching the user list "+obj.toString());
        }catch(Exception e){
            logger.info("Exception while fetching the user list "+e.getMessage());
            e.printStackTrace();
        }finally{
            return obj;
        }

    }

    @Override
    public UserDetails fetchuserdetailbyid(Long uid) {
        return userdetailsrepository.findById(uid).get();
    }

    @Override
    public void deleteuser(Long uid) {
        userdetailsrepository.deleteById(uid);
    }

    @Override
    public UserDetails updateuserdetails(Long uid, UserDetails userdetails) {
        UserDetails detDB=userdetailsrepository.findById(uid).get();

        if(Objects.nonNull(userdetails.getFirstname())&&
                !"".equalsIgnoreCase(userdetails.getFirstname())){
            detDB.setFirstname(userdetails.getFirstname());
        }

        if(Objects.nonNull(userdetails.getLastname())&&
                !"".equalsIgnoreCase(userdetails.getLastname())){
            detDB.setLastname(userdetails.getLastname());
        }
        if(Objects.nonNull(userdetails.getPassword())&&
                !"".equalsIgnoreCase(userdetails.getPassword())){
            detDB.setPassword(userdetails.getPassword());
        }
        if(Objects.nonNull(userdetails.getBio())&&
                !"".equalsIgnoreCase(userdetails.getBio())){
            detDB.setBio(userdetails.getBio());
        }
        return userdetailsrepository.save(detDB);
    }


}

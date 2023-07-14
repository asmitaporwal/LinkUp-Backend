package com.hus23.assignment.socialmediaplatform.repository;

import com.hus23.assignment.socialmediaplatform.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    Optional<UserDetails> findByUsername(String Username);

    @Query("SELECT ud FROM UserDetails ud WHERE CONCAT(ud.username, ud.firstname,ud.lastname) LIKE %?1%")
    public List<UserDetails> search(String keyword);

}

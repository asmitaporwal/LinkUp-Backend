package com.hus23.assignment.socialmediaplatform.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    @Column(unique = true)
    private String username;
    private String firstname;
    private String lastname;

    private String bio;

    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Posts> posts;


}
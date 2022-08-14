package com.simplilearn.controller;

import com.simplilearn.entity.UserEntity;
import com.simplilearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService svc;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user= svc.getUserByUserName(username);
        return new MyUserDetail(user);
        //return new MyUserDetail(username);
    }
}

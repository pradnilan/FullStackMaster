package com.simplilearn.controller;

import com.simplilearn.entity.UserEntity;
import com.simplilearn.service.UserService;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MyUserDetail implements UserDetails {

    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;

    public MyUserDetail(UserEntity user){
        this.userName=user.getUserName();
        this.password=user.getPassword();
        this.authorities=Arrays.stream(new String[]{user.getProfile().getRole()})
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

/*public MyUserDetail(String userName){
    this.userName=userName;
}*/


    public MyUserDetail() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    @Override
    public String getPassword() {
        //return password;
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

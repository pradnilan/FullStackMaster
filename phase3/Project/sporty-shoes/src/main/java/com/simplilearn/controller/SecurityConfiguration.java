package com.simplilearn.controller;

import com.simplilearn.controller.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailService userDetailService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("prad")
                .password("prad123")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin123")
                .roles("ADMIN");*/
        auth.userDetailsService(userDetailService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .csrf().ignoringAntMatchers("/**/{id}")
                .and().authorizeRequests()
               //.antMatchers("/","static/css","static/js").permitAll()
               // .antMatchers("/user").hasRole("administrator")
               .antMatchers(HttpMethod.PUT,"/**/{id}").hasRole("ADMIN")
               .antMatchers("/**").hasRole("ADMIN")
               //.antMatchers("/**").permitAll()
                .and().formLogin();

    }
}

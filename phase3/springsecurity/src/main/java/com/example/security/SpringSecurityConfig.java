package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().
        anyRequest().authenticated();*/

        http.httpBasic().and().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/protected").hasRole("USER") //registered user
                .antMatchers("/admin").hasRole("ADMIN")
                .and().formLogin(); //all user; //Admin
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(new CustomAuthProvider());
        /*auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
                .and()
                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");*/
    }

 /*   @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}

package com.MoAbdelHamied.TodoApp.Security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String [] puplicUrls = {
      "api/v1/todos"
    } ;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http .
                cors() .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy
                            (SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                    .antMatchers(puplicUrls).permitAll() .
                    anyRequest().authenticated()
                    .and().httpBasic();


    }
}

package com.MoAbdelHamied.TodoApp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
        @Autowired
        private UserRepository userRepository ;
   @Bean
        private PasswordEncoder passwordEncoder () {
            return new BCryptPasswordEncoder();
        }
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return new User("mohamed" , passwordEncoder().encode("admin") , AuthorityUtils.NO_AUTHORITIES);
        }

        public void save(AppUser user)
        {
            user.setPassword(passwordEncoder().encode(user.getPassword()));
            userRepository.save(user);
        }

        public List <AppUser> findAllUser() {

             return userRepository.findAll();
            }
          }

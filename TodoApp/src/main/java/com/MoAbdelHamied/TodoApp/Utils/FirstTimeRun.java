package com.MoAbdelHamied.TodoApp.Utils;

import com.MoAbdelHamied.TodoApp.Security.AppUser;
import com.MoAbdelHamied.TodoApp.Security.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static javafx.beans.binding.Bindings.isEmpty;


@Component

public class FirstTimeRun implements CommandLineRunner {
    private final Log logger =  LogFactory.getLog(FirstTimeRun.class);
    @Autowired
    private UserService userService ;
    @Override
    public void run(String... args) throws Exception {


       if (userService.findAllUser().isEmpty()) {
         logger.info("not found");
           AppUser user = new AppUser("mohamed", "admin", "mohamed@gmail.com");
           userService.save(user);
       }
    }
}

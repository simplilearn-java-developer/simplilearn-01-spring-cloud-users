package com.simplilearn.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.spring.jpa.User;
import com.simplilearn.spring.service.UserService;

@RestController
public class UserController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    static final String PORT_PROPERTY = "local.server.port";

    @Autowired
    Environment environment;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> list() {

        logger.debug("Listing Users...");

        return this.userService.list();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {

        logger.debug("Creating User... {}", user);

        this.userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public User searchUser(@PathVariable int id) {

        logger.debug("Searching User... UserID: {}",id);

        return this.userService.findUser(id);
    }

    @GetMapping("/users/sleep/{id}")
    public User searchUserSleep(@PathVariable int id) {

        logger.debug("Searching User... UserID: {}",id);

        String port = this.environment.getProperty(PORT_PROPERTY);

        return this.userService.findUserSleep(id,port);
    }

    @GetMapping("/users/{id}/{username}")
    public User searchUser(@PathVariable int id, @PathVariable String username) {

        logger.debug("Searching User... UserID: {}, Username: {}",id,username);

        return this.userService.findUser(new User(id,username));
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {

        logger.debug("Updating User... {}",user);

        this.userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {

        logger.debug("Deleting User... UserID: {}",id);

        this.userService.deleteUser(id);
    }

}

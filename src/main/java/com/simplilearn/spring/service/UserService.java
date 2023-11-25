package com.simplilearn.spring.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.spring.bean.UserSleep;
import com.simplilearn.spring.jpa.User;
import com.simplilearn.spring.proxy.SleepProxy;
import com.simplilearn.spring.repository.UserRepository;
import com.simplilearn.spring.util.Util;

@Service
public class UserService {


    @Autowired
    SleepProxy proxy;

    @Autowired
    UserRepository userRepository;


    public List<User> list() {

        List<User> users = this.userRepository.findAll();

        return users;
    }

    public void createUser(User user) {

        this.validateUser(user);

        user.setStatus("A");

        this.userRepository.save(user);
    }

    public User findUser(int idUser) {

        return this.userRepository.findById(idUser).orElse(null);
    }

    public User findUserSleep(int idUser, String port) {

        return this.userRepository.findById(idUser)
                 .map(user -> { String birth = Util.formatDate(user.getBirth());
                                UserSleep userSleep = this.proxy.getSleepRecommendation(birth);
                                BeanUtils.copyProperties(user, userSleep);
                                userSleep.setUsersEnvironment(port);
                                return userSleep;})
                 .orElse(null);
    }

    public User findUser(String username) {

        return this.userRepository.findByUsernameIgnoreCase(username);
    }

    public User findUser(User user) {

        return this.userRepository.findByIdUserNotAndUsernameIgnoreCase(user.getIdUser(), user.getUsername());
    }

    public void updateUser(User user) {

        this.validateUser(user);

        this.userRepository.findById(user.getIdUser())
           .ifPresent(u -> {
               u.setFirstName(user.getFirstName());
               u.setLastName(user.getLastName());
               u.setUsername(user.getUsername());
               u.setBirth(user.getBirth());

               this.userRepository.save(u);
           });
    }

    public void deleteUser(int idUser) {

        this.userRepository.deleteById(idUser);
    }

    private void validateUser(User user) {

        if (user.getFirstName().isEmpty() ||
            user.getLastName().isEmpty() ||
            user.getUsername().isEmpty()) {
            throw new RuntimeException("Invalid User Data: " + user);
        }
    }

}

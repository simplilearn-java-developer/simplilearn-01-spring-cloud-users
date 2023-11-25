package com.simplilearn.spring.bean;

import com.simplilearn.spring.jpa.User;

public class UserSleep extends User {

    private static final long serialVersionUID = 1L;

    String recommendation;
    String sleepEnvironment;
    String usersEnvironment;


    public String getRecommendation() {
        return recommendation;
    }
    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
    public String getSleepEnvironment() {
        return sleepEnvironment;
    }
    public void setSleepEnvironment(String sleepEnvironment) {
        this.sleepEnvironment = sleepEnvironment;
    }
    public String getUsersEnvironment() {
        return usersEnvironment;
    }
    public void setUsersEnvironment(String usersEnvironment) {
        this.usersEnvironment = usersEnvironment;
    }

}

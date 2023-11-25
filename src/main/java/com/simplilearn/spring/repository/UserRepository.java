package com.simplilearn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.spring.jpa.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public User findByUsernameIgnoreCase(String username);
	public User findByIdUserNotAndUsernameIgnoreCase(int idUser,String username);
}

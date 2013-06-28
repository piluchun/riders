package com.leadtone.riders.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.leadtone.riders.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByEmail(String email);
	
	User findByEmailAndPwd(String email,String pwd);
}

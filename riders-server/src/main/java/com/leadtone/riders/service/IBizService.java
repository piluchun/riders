package com.leadtone.riders.service;

import com.leadtone.riders.entity.User;


public interface IBizService {

	public boolean register(User user) throws Exception;
	
	public boolean login(String email,String password);
	
	
}

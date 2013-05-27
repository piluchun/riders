package com.leadtone.riders.service;

import org.springframework.stereotype.Service;


@Service
public class BizServiceImpl implements IBizService {


	@Override
	public boolean login(String email,String password) {
		return true;
	}

}

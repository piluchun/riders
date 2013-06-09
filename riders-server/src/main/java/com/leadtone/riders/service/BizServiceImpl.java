package com.leadtone.riders.service;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtone.riders.dao.UserDao;
import com.leadtone.riders.entity.User;


@Service
public class BizServiceImpl implements IBizService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public boolean login(String email,String password) {
		return true;
	}

	@Override
	public boolean register(User user) throws Exception {
		User saveUser = new User();
		BeanUtils.copyProperties(saveUser, user);
		User existUser = userDao.findByEmail(user.getEmail());
		if (existUser!=null && !"".endsWith(existUser.getEmail())){
			return false;
		}
		userDao.save(saveUser);
		return true;
		
	}

}

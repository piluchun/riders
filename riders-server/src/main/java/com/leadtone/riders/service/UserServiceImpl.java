package com.leadtone.riders.service;

import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtone.riders.MsgConstants;
import com.leadtone.riders.RidersBiz;
import com.leadtone.riders.dao.UserDao;
import com.leadtone.riders.entity.User;
import com.leadtone.riders.protocol.beans.Content;
import com.leadtone.riders.protocol.converter.ResponseContentHelper;

@Service
public class UserServiceImpl {

	private Logger log = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@RidersBiz("login")
	public Content authUser(HashMap<String, Object> contentMap) {
		Content resultContent = null;
		try {
			String email = (String) contentMap.get("email");
			String pwd = (String) contentMap.get("pwd");
			User existUser = userDao.findByEmailAndPwd(email, pwd);
			if (existUser != null && !"".endsWith(existUser.getEmail())) {
				resultContent = ResponseContentHelper.genSimpleResponseContentWithoutType(
						MsgConstants.ERROR_CODE_0, "user logined!");
			} else {
				resultContent = ResponseContentHelper.genSimpleResponseContentWithoutType(
						MsgConstants.ERROR_CODE_1, "user login failed!");
			}

		} catch (Exception e) {
			resultContent = ResponseContentHelper
					.genSimpleResponseContentWithoutType(
							MsgConstants.SERVER_INNER_ERROR_CODE,
							MsgConstants.SERVER_INNER_ERROR_MSG);
			log.error("AuthUser Error : " + e.getMessage());
			log.error(e);
		}
		return resultContent;
	}

	@RidersBiz("register")
	public Content register(HashMap<String, Object> contentMap) {
		Content resultContent = null;
		try {
			User saveUser = new User();
			BeanUtils.populate(saveUser, contentMap);
			User existUser = userDao.findByEmail(saveUser.getEmail());
			if (existUser != null && !"".endsWith(existUser.getEmail())) {
				ResponseContentHelper.genSimpleResponseContentWithoutType(
						MsgConstants.ERROR_CODE_2, "user already registered!");
			}
			userDao.save(saveUser);
			ResponseContentHelper.genSimpleResponseContentWithoutType(
					MsgConstants.ERROR_CODE_0, "user register successed!");
		} catch (Exception e) {
			resultContent = ResponseContentHelper
					.genSimpleResponseContentWithoutType(
							MsgConstants.SERVER_INNER_ERROR_CODE,
							MsgConstants.SERVER_INNER_ERROR_MSG);
			log.error("AuthUser Error : " + e.getMessage());
			log.error(e);
		}
		return resultContent;
	}

	public static void main(String[] args) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "a");
		map.put("pwd", "b");

		User user = new User();
		try {
			BeanUtils.populate(user, map);
			System.out.println(user.getEmail());
			System.out.println(user.getPwd());
			System.out.println(user.getMobile());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.leadtone.riders.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.leadtone.riders.ServerConstants;
import com.leadtone.riders.protocol.beans.LoginInfo;
import com.leadtone.riders.protocol.beans.RidersMessage;
import com.leadtone.riders.utils.JsonProtocolParser;

public class ProtocolServiceImpl implements IProtocolService {

	@Autowired
	private IBizService bizService;
	
	@Autowired
	private IMessageService msgService;
	
	@Override
	public String process(RidersMessage message) {
		
		String subject = message.getSubject();
		
		if (StringUtils.isNotBlank(subject)){
			return null;
		}
		if (ServerConstants.SUBJECT_LOGIN.equals(subject)){
			boolean result = authUser(message.getContent());
			msgService.sendMsg(message);
		}
		return null;
		
	}
	
	
	private boolean authUser(String loginJsonStr){
		try {
			LoginInfo loginInfo = JsonProtocolParser.parseLoginInfo(loginJsonStr);
			bizService.login(loginInfo);
		} catch (Exception e) {
			return false;
		} 
		return true;
	}


	@Override
	public boolean router(RidersMessage message) {
		// TODO Auto-generated method stub
		return false;
	}

}

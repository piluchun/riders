package com.leadtone.riders.service;

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtone.riders.ConcurrentContext;
import com.leadtone.riders.ServerConstants;
import com.leadtone.riders.protocol.beans.LoginInfo;
import com.leadtone.riders.protocol.beans.ResultInfo;
import com.leadtone.riders.protocol.beans.RidersMessage;
import com.leadtone.riders.protocol.converter.ProtocolConverter;
import com.leadtone.riders.server.RiderChannel;


@Service
public class ProtocolServiceImpl implements IProtocolService {

	private static final Logger log = Logger.getLogger(ProtocolServiceImpl.class);
	
	private ConcurrentHashMap<String,RiderChannel> channelsMap = ConcurrentContext.getChannelMapInstance();
	 
	@Autowired
	private IBizService bizService;
	
	@Override
	public String process(RidersMessage message) {
		String result = "";
		String subject = message.getSubject();
		
		if (StringUtils.isBlank(subject)){
			return ServerConstants.ERROR_SUBJECT;
		}
		if (ServerConstants.SUBJECT_LOGIN.equals(subject)){
			result = authUser(message.getContent());
		} 
		return result;
		
	}
	


	@Override
	public boolean route(String request) {
		
		for (String email : channelsMap.keySet()){
			RiderChannel channel = channelsMap.get(email);
			try {
				channel.getChannel().write(new TextWebSocketFrame(request));
			} catch(Exception e){
				log.error(e);
			}
		}
		return true;
	}

	
	private String authUser(Object content){
		ResultInfo resultJson = new ResultInfo();
		String resultJsonStr = "";
		try {
//			LoginInfo loginInfo = ProtocolConverter.marshallLoginInfo(loginJsonStr);
			HashMap<String,String> contentMap = (HashMap<String, String>) content;
			if (bizService.login(contentMap.get("email"),contentMap.get("password"))){
				resultJson.setResult(0);
				resultJson.setMsg("login successed!");
			} else {
				resultJson.setResult(-1);
				resultJson.setMsg("login failed!");
			}
			resultJsonStr = ProtocolConverter.unmarshallResultInfo(resultJson);
		} catch (Exception e) {
			log.error("AuthUser Error : " + e.getMessage());
			log.error(e);
			resultJsonStr = ServerConstants.ERROR_RESULT_CONTENT;
		} 
		return resultJsonStr;
	}
}

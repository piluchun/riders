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
import com.leadtone.riders.protocol.beans.RidersMessage;
import com.leadtone.riders.protocol.converter.ProtocolConverter;
import com.leadtone.riders.server.RiderChannel;

@Service
public class ProtocolServiceImpl implements IProtocolService {

	private static final Logger log = Logger.getLogger(ProtocolServiceImpl.class);

	private ConcurrentHashMap<String, RiderChannel> channelsMap = ConcurrentContext.getChannelMapInstance();

	@Autowired
	private IBizService bizService;

	@Override
	public HashMap<String, Object> process(RidersMessage message) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		String subject = message.getSubject();

		if (StringUtils.isBlank(subject)) {

			return ProtocolConverter.getDefaultErrorSubject();
		}
		if (ServerConstants.SUBJECT_LOGIN.equals(subject)) {
			result = authUser(message.getContent());
		}
		return result;

	}

	@Override
	public boolean route(String from, String to, String request) {
		if (ServerConstants.TO_ALL.equalsIgnoreCase(to)) {
			for (String email : channelsMap.keySet()) {
				if (from.equalsIgnoreCase(email)) {
					continue;
				}
				RiderChannel channel = channelsMap.get(email);
				writeToChannel(channel, request);
			}
		} else {
			RiderChannel channel = channelsMap.get(to);
			writeToChannel(channel, request);
		}
		return true;
	}

	private void writeToChannel(RiderChannel channel, String request) {
		try {
			if(channel.isLogined()){
				channel.getChannel().write(new TextWebSocketFrame(request));
			} else {
				//	TODO
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, Object> authUser(Object content) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			HashMap<String, String> contentMap = (HashMap<String, String>) content;
			if (bizService.login(contentMap.get("email"),
					contentMap.get("password"))) {
				resultMap.put("result", 0);
				resultMap.put("msg", "login successed!");
			} else {
				resultMap.put("result", -1);
				resultMap.put("msg", "login failed!");
			}
		} catch (Exception e) {
			log.error("AuthUser Error : " + e.getMessage());
			log.error(e);
		}
		return resultMap;
	}
}

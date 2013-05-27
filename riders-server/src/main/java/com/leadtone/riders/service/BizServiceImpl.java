package com.leadtone.riders.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.leadtone.riders.ConcurrentContext;
import com.leadtone.riders.protocol.beans.LoginInfo;
import com.leadtone.riders.server.RiderChannel;


@Service
public class BizServiceImpl implements IBizService {

	 private ConcurrentHashMap<String,RiderChannel> channelsMap = ConcurrentContext.getChannelMapInstance();
	@Override
	public boolean login(LoginInfo user) {
		RiderChannel riderChannel = channelsMap.get(user.getEmail());
		if (riderChannel !=null){
			riderChannel.setLogined(true);
		}
		return true;
	}

}

package com.leadtone.riders.service;

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.leadtone.riders.ConcurrentContext;
import com.leadtone.riders.protocol.beans.RidersMessage;
import com.leadtone.riders.server.RiderChannel;


@Service
public class MessageServiceImpl implements IMessageService {

	private ConcurrentHashMap<String,RiderChannel> channelsMap = ConcurrentContext.getChannelMapInstance();
	
	@Override
	public void sendMsg(RidersMessage msg) {
		for (String email : channelsMap.keySet()){
			RiderChannel channel = channelsMap.get(email);
			channel.getChannel().write(new TextWebSocketFrame((String) msg.getContent()));
		}
	}

}

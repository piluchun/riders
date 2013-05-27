package com.leadtone.riders.server;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leadtone.riders.protocol.beans.RidersMessage;

public class ResponseHelper {

	private static Logger log = Logger.getLogger(ResponseHelper.class);

	private static ObjectMapper mapper = new ObjectMapper();// can reuse, share globally
	
	// 异步消息无需转化 FROM TO
	public static String genAsyncResponse(RidersMessage message) {
		String result = "";
		try {
			long timeStamp = System.currentTimeMillis();
			message.setMsg_id(genMessageId(message.getFrom(), message.getTo(), timeStamp));
			message.setCreateDate(Long.toString(timeStamp));
			result = mapper.writeValueAsString(message);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		log.info("Async response to client : " + result);
		return result;
	}

	// 同步消息需要将FROM TO 信息互换
	public static String genSyncResponse(RidersMessage message) {
		RidersMessage newMessage = swapFromTo(message);
		String result = "";
		try {
			long timeStamp = System.currentTimeMillis();
			newMessage.setMsg_id(genMessageId(message.getFrom(), message.getTo(), timeStamp));
			newMessage.setCreateDate(Long.toString(timeStamp));
			result = mapper.writeValueAsString(newMessage);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		log.info("Sync response to client : " + result);
		return result;
	}
	
	private static RidersMessage swapFromTo(RidersMessage message){
		String from = message.getFrom();
		String to = message.getTo();
		RidersMessage swapedMsg = message;
		swapedMsg.setFrom(to);
		swapedMsg.setTo(from);
		return swapedMsg;
	}
	
	private static String genMessageId(String from,String to,long timeStamp ){
		return from+"-"+to+"-"+timeStamp;
	}
}

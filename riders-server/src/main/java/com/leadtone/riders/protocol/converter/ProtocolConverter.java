package com.leadtone.riders.protocol.converter;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leadtone.riders.protocol.beans.RidersMessage;

public class ProtocolConverter {

	private static ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

	public static RidersMessage marshallBasicMsg(String requestStr)
			throws JsonParseException, JsonMappingException, IOException {
		RidersMessage msg = mapper.readValue(requestStr, RidersMessage.class);
		return msg;
	}

	public static HashMap<String,Object> getDefaultErrorSubject(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("error_code", -2);
		resultMap.put("error_msg", "unsupport subject");
		return resultMap;
	}
	
	public static HashMap<String,Object> getDefaultErrorRequest(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("error_code", -1);
		resultMap.put("error_msg", "bad request");
		return resultMap;
	}
	public static HashMap<String,Object> getDefaultSuccessed(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("error_code", 0);
		resultMap.put("error_msg", "successed");
		return resultMap;
	}
	public static HashMap<String,Object> getInnerErrorContent(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("result", -999);
		resultMap.put("msg", "server inner error!");
		return resultMap;
	}
	
	public static HashMap<String,Object> getSentMsgSuccessedContent(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("result", 0);
		resultMap.put("msg", "message send successed.");
		return resultMap;
	}
	
	public static HashMap<String,Object> getSentMsgFailedContent(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("result", -1);
		resultMap.put("msg", "message send failed.");
		return resultMap;
	}
}

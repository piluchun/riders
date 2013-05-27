package com.leadtone.riders.protocol.converter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leadtone.riders.protocol.beans.LoginInfo;
import com.leadtone.riders.protocol.beans.ResultInfo;
import com.leadtone.riders.protocol.beans.RidersMessage;

public class ProtocolConverter {

	private static ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
	public static RidersMessage marshallBasicMsg(String requestStr)
			throws JsonParseException, JsonMappingException, IOException {
//		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		RidersMessage msg = mapper.readValue(requestStr, RidersMessage.class);
		return msg;
	}

	public static LoginInfo marshallLoginInfo(String content)
			throws JsonParseException, JsonMappingException, IOException {
//		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		LoginInfo msg = mapper.readValue(content, LoginInfo.class);
		return msg;
	}

	public static ResultInfo marshallResultInfo(String content)
			throws JsonParseException, JsonMappingException, IOException {
//		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		ResultInfo msg = mapper.readValue(content, ResultInfo.class);
		return msg;
	}
	
	
	public static String  unmarshallResultInfo(ResultInfo resultInfo)
			throws JsonParseException, JsonMappingException, IOException {
//		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		return mapper.writeValueAsString(resultInfo);
	}
}

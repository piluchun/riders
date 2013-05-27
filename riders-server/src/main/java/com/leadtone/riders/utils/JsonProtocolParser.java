package com.leadtone.riders.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leadtone.riders.protocol.beans.LoginInfo;
import com.leadtone.riders.protocol.beans.RidersMessage;

public class JsonProtocolParser {

	public static RidersMessage parseBasicMsg(String requestStr)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		RidersMessage msg = mapper.readValue(requestStr, RidersMessage.class);
		return msg;
	}

	public static LoginInfo parseLoginInfo(String content)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		LoginInfo msg = mapper.readValue(content, LoginInfo.class);
		return msg;
	}

	
}

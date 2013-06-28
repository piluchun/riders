package com.leadtone.riders.protocol.converter;

import java.io.IOException;

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
//
//	public static ResponseContent getDefaultErrorSubject(){
//		ResponseContent rc = new ResponseContent();
//		HashMap<String,Object> resultMap = new HashMap<String,Object>();
//		resultMap.put("error_code", -2);
//		resultMap.put("error_msg", "unsupport subject");
//		rc.setResultContent(resultMap);
//		return rc;
//	}
//	
//	public static ResponseContent getDefaultErrorRequest(){
//		ResponseContent rc = new ResponseContent();
//		HashMap<String,Object> resultMap = new HashMap<String,Object>();
//		resultMap.put("error_code", -1);
//		resultMap.put("error_msg", "bad request");
//		rc.setResultContent(resultMap);
//		return rc;
//	}
//	public static ResponseContent getDefaultSuccessed(){
//		ResponseContent rc = new ResponseContent();
//		HashMap<String,Object> resultMap = new HashMap<String,Object>();
//		resultMap.put("error_code", 0);
//		resultMap.put("error_msg", "successed");
//		rc.setResultContent(resultMap);
//		return rc;
//	}
//	public static ResponseContent getInnerErrorContent(){
//		ResponseContent rc = new ResponseContent();
//		HashMap<String,Object> resultMap = new HashMap<String,Object>();
//		resultMap.put("result", -999);
//		resultMap.put("msg", "server inner error!");
//		rc.setResultContent(resultMap);
//		return rc;
//	}
//	
//	public static ResponseContent getSentMsgSuccessedContent(){
//		ResponseContent rc = new ResponseContent();
//		HashMap<String,Object> resultMap = new HashMap<String,Object>();
//		resultMap.put("result", 0);
//		resultMap.put("msg", "message send successed.");
//		rc.setResultContent(resultMap);
//		return rc;
//	}
//	
//	public static ResponseContent getSentMsgFailedContent(){
//		ResponseContent rc = new ResponseContent();
//		HashMap<String,Object> resultMap = new HashMap<String,Object>();
//		resultMap.put("result", -1);
//		resultMap.put("msg", "message send failed.");
//		rc.setResultContent(resultMap);
//		return rc;
//	}
}

package com.leadtone.riders.test;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leadtone.riders.protocol.beans.Content;
import com.leadtone.riders.protocol.beans.RidersMessage;

public class TestJackson {

	private static ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
	
	private static String jsonStr = "{\"msg_id\":\"1vafd\",\"from\":\"999991\",\"to\":\"AAAAAA\",\"subject\":\"msg\",\"content\":{\"type\":\"test\",\"params\":{\"length\":\"11\",\"body\":\"hello world\"}},\"createDate\":\"20130227121212\",\"status\":\"0\"}";

	public static void main(String[] args) {
		
		try {
			RidersMessage r = mapper.readValue(jsonStr, RidersMessage.class);
			Content rc = r.getContent();
			System.out.println(rc.getType());
			System.out.println(rc.getData());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

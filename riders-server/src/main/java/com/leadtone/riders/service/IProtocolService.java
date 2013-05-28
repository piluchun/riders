package com.leadtone.riders.service;

import java.util.HashMap;

import com.leadtone.riders.protocol.beans.RidersMessage;

public interface IProtocolService {

	public HashMap<String,Object> process(RidersMessage message);
	
	public boolean route(String from,String to,String message);
	
}

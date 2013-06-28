package com.leadtone.riders.service;

import com.leadtone.riders.protocol.beans.Content;
import com.leadtone.riders.protocol.beans.RidersMessage;

public interface IProtocolService {

	public Content dispatch(RidersMessage message);
	
	public boolean route(String from,String to,String message);
	
}

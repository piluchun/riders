package com.leadtone.riders.service;

import com.leadtone.riders.protocol.beans.RidersMessage;

public interface IProtocolService {

	public String process(RidersMessage message);
	
	public boolean router(RidersMessage message);
	
}

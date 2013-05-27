package com.leadtone.riders;

import java.util.concurrent.ConcurrentHashMap;

import com.leadtone.riders.server.RiderChannel;

public class ConcurrentContext {

	private static volatile ConcurrentHashMap<String, RiderChannel> map = null;

	public static ConcurrentHashMap<String, RiderChannel> getChannelMapInstance() {
		if (map == null) {
			map = new ConcurrentHashMap<String, RiderChannel>();
		}
		return map;
	}

}

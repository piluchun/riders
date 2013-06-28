package com.leadtone.riders.service;

import com.leadtone.riders.protocol.beans.Content;

public interface IBizService {
	
	public  Content process(Content requestContent,Object classInstance);
	
	
}

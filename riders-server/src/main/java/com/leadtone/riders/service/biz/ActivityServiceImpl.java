package com.leadtone.riders.service.biz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtone.riders.dao.ActivityDao;

@Service
public class ActivityServiceImpl {

	
	private Logger log = Logger.getLogger(ActivityServiceImpl.class);

	@Autowired
	private ActivityDao activityDao;
	
	
	
}

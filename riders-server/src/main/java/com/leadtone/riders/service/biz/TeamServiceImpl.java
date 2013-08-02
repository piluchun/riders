package com.leadtone.riders.service.biz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtone.riders.dao.TeamDao;


@Service
public class TeamServiceImpl {

	
private Logger log = Logger.getLogger(TeamServiceImpl.class);

	
	@Autowired
	private TeamDao teamDao;
	
	
}

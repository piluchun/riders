package com.leadtone.riders.service.biz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtone.riders.dao.SuggestionDao;


@Service
public class SuggestionServiceImpl {

	private Logger log = Logger.getLogger(SuggestionServiceImpl.class);

	
	@Autowired
	private SuggestionDao sDao;
	
	
}

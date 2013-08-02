package com.leadtone.riders.service.biz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtone.riders.dao.ReportDao;


@Service
public class ReportServiceImpl {
	
	private Logger log = Logger.getLogger(ReportServiceImpl.class);

	
	@Autowired
	private ReportDao reportDao;

}

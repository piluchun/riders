package com.leadtone.riders.service.biz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtone.riders.dao.CommentDao;


@Service
public class CommentServiceImpl {

	
	private Logger log = Logger.getLogger(CommentServiceImpl.class);

	
	@Autowired
	private CommentDao ommentDao;
	
	
}

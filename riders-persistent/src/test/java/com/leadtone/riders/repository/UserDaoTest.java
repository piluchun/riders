package com.leadtone.riders.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;

import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.leadtone.riders.dao.UserDao;
import com.leadtone.riders.data.UserData;
import com.leadtone.riders.entity.User;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private UserDao userDao;

	@Test
	public void findUser() throws Exception {
//		Page<User> tasks = userDao.findByUserId(2L, new PageRequest(0, 100, Direction.ASC, "id"));
//		assertEquals(5, tasks.getContent().size());
//		assertEquals(new Long(1), tasks.getContent().get(0).getId());

//		tasks = userDao.findByUserId(99999L, new PageRequest(0, 100, Direction.ASC, "id"));
//		assertEquals(0, tasks.getContent().size());
		User user = UserData.randomNewUser("lvqi", "leadtone.com");
		userDao.save(user);
		User user_1 = userDao.findOne(Long.valueOf(1));
		assertNotNull(user_1);
		User user_2 = userDao.findByEmail(user_1.getEmail());
		assertNotNull(user_1);
//		assertEquals(user_1, user_2);
		
		
	}
}

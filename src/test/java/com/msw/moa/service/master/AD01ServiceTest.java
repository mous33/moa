package com.msw.moa.service.master;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.msw.moa.json.admin.AD01UserResultInfo;
import com.msw.moa.service.admin.AD01Service;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mvc.xml" })
public class AD01ServiceTest {

	@Autowired
	private AD01Service target;

	@Test
	public void testGetUsers() {
		List<AD01UserResultInfo> list = target.getUsers();
		System.out.println(list.size());
	}

}

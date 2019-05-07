package com.cc.durid.monitor.service;

import com.cc.durid.monitor.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
	@Autowired
	private TestDao testDao;

	@Transactional(rollbackFor = Exception.class)
	public void addTumbup(){
		testDao.addThumbsup("123457");
	}
}

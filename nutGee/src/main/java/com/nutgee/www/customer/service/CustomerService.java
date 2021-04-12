package com.nutgee.www.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutgee.www.customer.dao.CustomerDAO;
import com.nutgee.www.customer.vo.CustomerVO;

@Service
public class CustomerService{

	@Autowired
	CustomerDAO cDao;
	
	public CustomerVO selectCustomer(CustomerVO cvo) {
		// TODO Auto-generated method stub
		return cDao.selectCustomer(cvo);
	}

	public int signupCustomer(CustomerVO cvo) {
		// TODO Auto-generated method stub
		return cDao.signupCustomer(cvo);
	}
}

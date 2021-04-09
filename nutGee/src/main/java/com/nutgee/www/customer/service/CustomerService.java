package com.nutgee.www.customer.service;

import com.nutgee.www.customer.vo.CustomerVO;

public interface CustomerService {
	public CustomerVO selectCustomer(CustomerVO cvo);
	public int signupCustomer(CustomerVO cvo);
}

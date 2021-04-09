package com.nutgee.www.customer.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.nutgee.www.customer.vo.CustomerVO;

@Mapper
public interface CustomerDAO {
	//public List<CustomerVO> selectCustomerList(CustomerVO cvo);
	public CustomerVO selectCustomer(CustomerVO cvo);
	public int signupCustomer(CustomerVO cvo);

}

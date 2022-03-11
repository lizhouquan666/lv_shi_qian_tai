package com.wanxi.service.impl;

import com.wanxi.dao.CustomerDao;
import com.wanxi.dao.impl.CustomerImpl;
import com.wanxi.model.CustomerModel;
import com.wanxi.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<CustomerModel> getCustomerModelList() {
        CustomerDao customerDao= new CustomerImpl();
        return customerDao.getCustomerModelList();
    }
}

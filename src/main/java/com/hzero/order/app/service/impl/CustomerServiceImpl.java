package com.hzero.order.app.service.impl;

import com.hzero.order.app.service.CustomerService;
import com.hzero.order.domain.entity.Company;
import com.hzero.order.domain.entity.Customer;
import com.hzero.order.infra.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 应用服务默认实现
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int updateByCustomerId(Customer customer) {
        return customerMapper.updateByCustomerId(customer);
    }
}

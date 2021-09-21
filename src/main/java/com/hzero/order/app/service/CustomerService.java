package com.hzero.order.app.service;

import com.hzero.order.domain.entity.Company;
import com.hzero.order.domain.entity.Customer;

/**
 * 应用服务
 *
 */
public interface CustomerService {
    int updateByCustomerId(Customer customer);

}

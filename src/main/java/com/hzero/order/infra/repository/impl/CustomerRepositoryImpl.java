package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.entity.Customer;
import com.hzero.order.domain.repository.CustomerRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

/**
 *  资源库实现
 *
 */
@Component
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {

  
}

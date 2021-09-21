package com.hzero.order.infra.mapper;

import com.hzero.order.domain.entity.Company;
import com.hzero.order.domain.entity.Customer;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * Mapper
 *
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    int updateByCustomerId(Customer customer);

}

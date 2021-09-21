package com.hzero.order.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.hzero.order.domain.entity.Company;
import com.hzero.order.domain.repository.CompanyRepository;
import org.springframework.stereotype.Component;

/**
 *  资源库实现
 *
 */
@Component
public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {

    @Override
    public int updateByPrimaryKeySelective(Company record) {
        return super.updateByPrimaryKeySelective(record);
    }
}

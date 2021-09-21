package com.hzero.order.app.service.impl;

import com.hzero.order.app.service.CompanyService;
import com.hzero.order.domain.entity.Company;
import com.hzero.order.infra.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 应用服务默认实现
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public int updateByCompanyId(Company company){
        return companyMapper.updateByCompanyId(company);
    };


}

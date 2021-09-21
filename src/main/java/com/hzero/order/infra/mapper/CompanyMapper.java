package com.hzero.order.infra.mapper;

import com.hzero.order.domain.entity.Company;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * Mapper
 *
 */
public interface CompanyMapper extends BaseMapper<Company> {
    int updateByCompanyId(Company company);
}

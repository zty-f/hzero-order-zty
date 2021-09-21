package com.hzero.order.infra.repository.impl;

import com.hzero.order.api.controller.dto.OrderReturnDTO;
import com.hzero.order.infra.mapper.SoHeaderMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  资源库实现
 *
 */
@Component
public class SoHeaderRepositoryImpl extends BaseRepositoryImpl<SoHeader> implements SoHeaderRepository {
    @Autowired
    private SoHeaderMapper soHeaderMapper;

    public void updateStatusBySoHeaderId(SoHeader soHeader){
        soHeaderMapper.updateStatusBySoHeaderId(soHeader);
    }

    public List<OrderReturnDTO> selectBySoHeaderId(Long soHeaderId){
        return  soHeaderMapper.selectBySoHeaderId(soHeaderId);
    }
}

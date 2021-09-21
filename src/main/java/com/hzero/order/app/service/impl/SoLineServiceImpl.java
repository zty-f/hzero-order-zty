package com.hzero.order.app.service.impl;

import com.hzero.order.app.service.SoLineService;
import com.hzero.order.domain.entity.SoLine;
import com.hzero.order.infra.mapper.SoLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应用服务默认实现
 **/
@Service
public class SoLineServiceImpl implements SoLineService {
    @Autowired
    private SoLineMapper soLineMapper;


    @Override
    public List<SoLine> selectById(Long soHeaderId) {
        return soLineMapper.selectById(soHeaderId);
    }
}

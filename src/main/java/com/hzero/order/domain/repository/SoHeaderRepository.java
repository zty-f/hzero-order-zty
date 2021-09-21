package com.hzero.order.domain.repository;

import com.hzero.order.api.controller.dto.OrderReturnDTO;
import com.hzero.order.domain.entity.SoHeader;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 资源库
 *
 */
public interface SoHeaderRepository extends BaseRepository<SoHeader> {
    void updateStatusBySoHeaderId(SoHeader soHeader);
    List<OrderReturnDTO> selectBySoHeaderId(Long soHeaderId);
}

package com.hzero.order.infra.mapper;

import com.hzero.order.api.controller.dto.OrderReturnDTO;
import com.hzero.order.domain.entity.SoHeader;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * Mapper
 *
 */
public interface SoHeaderMapper extends BaseMapper<SoHeader> {
  void updateStatusBySoHeaderId(SoHeader soHeader);
  List<OrderReturnDTO> selectBySoHeaderId(Long soHeaderId);
}

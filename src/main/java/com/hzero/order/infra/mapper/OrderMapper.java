package com.hzero.order.infra.mapper;

import com.hzero.order.api.controller.dto.OrderReturnDTO;
import com.hzero.order.domain.entity.Conditions;

import java.util.List;

/**
 * 订单查询
 */
public interface OrderMapper {
    /**
     * 条件查询订单汇总的数据
     * @param conditions 条件实体类
     * @return 订单汇总的数据
     **/
    List<OrderReturnDTO> list(Conditions conditions);

}

package com.hzero.order.app.service;

import com.hzero.order.api.controller.dto.OrderReturnDTO;
import com.hzero.order.domain.entity.Conditions;
import com.hzero.order.domain.entity.Order;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    /**
     * 条件分页查询订单汇总的数据
     * @param conditions 条件实体类
     * @return 分页以后的数据
     **/
    Page<OrderReturnDTO> list(PageRequest pageRequest, Conditions conditions);

     void deleteLineByHeadId(Long organizationId,
                                  Long soheaderid);

     ResponseEntity<String> deleteOrder(Long organizationId,
                                              Long soHeaderId);

     Order addOrder(Long organizationId, Order order);
}

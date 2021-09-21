package com.hzero.order.infra.mapper;

import com.hzero.order.domain.entity.SoLine;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * Mapper
 *
 */
public interface SoLineMapper extends BaseMapper<SoLine> {

    /**
     * 根据订单头id查询该订单下的所有行
     * @param soHeaderId 订单头id
     * @return 返回所有的订单行数据
     **/
    List<SoLine> selectById(Long soHeaderId);
}

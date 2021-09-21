package com.hzero.order.api.controller.v1;

import com.hzero.order.api.controller.dto.OrderReturnDTO;
import com.hzero.order.app.service.OrderService;
import com.hzero.order.app.service.SoHeaderService;
import com.hzero.order.app.service.SoLineService;
import com.hzero.order.config.SwaggerApiConfig;
import com.hzero.order.domain.entity.Conditions;
import com.hzero.order.domain.entity.Order;
import io.swagger.annotations.Api;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.boot.platform.code.constant.CodeConstants;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import java.security.Principal;
import java.util.List;

/**
 * 管理 API
 *
 */
@Api(tags = SwaggerApiConfig.SOHEADGER)
@RestController("soHeaderSiteController.v1")
@RequestMapping("/v1/{organizationId}/so-headers")
public class SoHeaderController extends BaseController {

    @Autowired
    private SoHeaderRepository soHeaderRepository;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;
    @Autowired
    private SoHeaderService soHeaderService;
    @Autowired
    private OrderService orderService;
    private final String ORDERNUMBER = "HZERO.ORDER.NUMBER";

    @ApiOperation(value = "订单头查询")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{soHeaderId}")
    public ResponseEntity<List<OrderReturnDTO>> detail(@PathVariable Long organizationId, @PathVariable Long soHeaderId) {
        List<OrderReturnDTO> orderReturnDTO = soHeaderRepository.selectBySoHeaderId(soHeaderId);
        return Results.success(orderReturnDTO);
    }


    /**
     * 修改订单状态
     */
    @ApiOperation(value = "订单状态修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping("/operate/{status}")
    public ResponseEntity<String> update(@PathVariable Long organizationId,@PathVariable String status,@RequestBody SoHeader soHeader, Principal principal) {
        return soHeaderService.updateStatus(status,soHeader, principal);
    }


    /**
     * 订单汇总查询
     */
    @ApiOperation(value = "订单汇总查询")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    @ProcessLovValue()
    public Page<OrderReturnDTO> list(@PathVariable Long organizationId,
                                     PageRequest pageRequest,
                                     Conditions conditions) {
        return orderService.list(pageRequest, conditions);
    }

    /**
     * 根据订单头ID删除订单
     */
    @ApiOperation(value = "订单删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<String> deleteId(@PathVariable Long organizationId,
                                           @RequestBody SoHeader soHeader) {
        return orderService.deleteOrder(organizationId, soHeader.getSoHeaderId());
    }

    /**
     * 添加相应的订单头和订单行
     */
    @ApiOperation(value = "订单保存")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public Order addOrder(@PathVariable Long organizationId,
                          @RequestBody Order order) {
        return orderService.addOrder(organizationId, order);
    }

}

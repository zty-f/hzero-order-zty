package com.hzero.order.api.controller.v1;

import com.hzero.order.api.controller.dto.OrderReturnDTO;
import com.hzero.order.app.service.OrderService;
import com.hzero.order.app.service.SoLineService;
import com.hzero.order.config.SwaggerApiConfig;
import com.hzero.order.domain.entity.Conditions;
import com.hzero.order.domain.entity.Order;
import com.hzero.order.domain.entity.SoLine;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 关于Order订单的相关API的Controller类
 */
@Api("")
@RestController("orderController.v1")
@RequestMapping("/v1/{organizationId}/so-headers")
public class OrderController extends BaseController {

}

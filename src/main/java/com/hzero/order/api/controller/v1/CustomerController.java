package com.hzero.order.api.controller.v1;

import com.hzero.order.app.service.CustomerService;
import com.hzero.order.config.SwaggerApiConfig;
import com.hzero.order.domain.entity.Customer;
import com.hzero.order.domain.repository.CustomerRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 *  管理 API
 *
 */
@Api(tags = SwaggerApiConfig.CUSTOMER)
@RestController("customerSiteController.v1")
@RequestMapping("/v1/{organizationId}/customers")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<Customer>> list(Customer customer, @ApiIgnore @SortDefault(value = Customer.FIELD_CUSTOMER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Customer> list = customerRepository.pageAndSort(pageRequest, customer);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> detail(@PathVariable Long customerId) {
        Customer customer = customerRepository.selectByPrimaryKey(customerId);
        return Results.success(customer);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        validObject(customer);
        customerRepository.insertSelective(customer);
        return Results.success(customer);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        customerService.updateByCustomerId(customer);
        return Results.success(customer);
    }

    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Customer customer) {
        customerRepository.deleteByPrimaryKey(customer);
        return Results.success();
    }

}

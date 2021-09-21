package com.hzero.order.api.controller.v1;

import com.hzero.order.app.service.SoLineService;
import com.hzero.order.config.SwaggerApiConfig;
import com.hzero.order.domain.entity.SoHeader;
import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hzero.order.domain.entity.SoLine;
import com.hzero.order.domain.repository.SoLineRepository;
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

import java.util.List;

/**
 *  管理 API
 *
 */
@Api(tags = SwaggerApiConfig.SOLINE)
@RestController("soLineSiteController.v1")
@RequestMapping("/v1/{organizationId}/so-lines")
public class SoLineController extends BaseController {

    @Autowired
    private SoLineRepository soLineRepository;

    @Autowired
    private SoLineService soLineService;

    @ApiOperation(value = "订单行查询")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<List<SoLine>> list(@PathVariable Long organizationId,SoLine soLine, @ApiIgnore @SortDefault(value = SoLine.FIELD_SO_LINE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<SoLine> list = soLineRepository.pageAndSort(pageRequest,  soLine);
        return Results.success(list);
    }


    @ApiOperation(value = "订单行创建")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<SoLine> create(@PathVariable Long organizationId,@RequestBody SoLine soLine) {
        validObject(soLine);
        soLineRepository.insertSelective(soLine);
        return Results.success(soLine);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<SoLine> update(@RequestBody SoLine soLine) {
        //SecurityTokenHelper.validToken(soLine);
        soLineRepository.updateByPrimaryKeySelective(soLine);
        return Results.success(soLine);
    }

    @ApiOperation(value = "订单行删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<SoLine> remove(@PathVariable Long organizationId, @RequestBody SoLine soLine) {
        soLineRepository.deleteByPrimaryKey(soLine.getSoLineId());
        return Results.success();
    }

}

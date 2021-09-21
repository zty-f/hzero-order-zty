package com.hzero.order.api.controller.v1;

import com.hzero.order.config.SwaggerApiConfig;
import com.hzero.order.domain.entity.Item;
import com.hzero.order.domain.repository.ItemRepository;
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
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 *  管理 API
 *
 */
@Api(tags = SwaggerApiConfig.ITEM)
@RestController("itemSiteController.v1")
@RequestMapping("/v1/{organizationId}/items")
public class ItemController extends BaseController {

    @Autowired
    private ItemRepository itemRepository;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<Item>> list(Item item, @ApiIgnore @SortDefault(value = Item.FIELD_ITEM_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Item> list = itemRepository.pageAndSort(pageRequest, item);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{itemId}")
    public ResponseEntity<Item> detail(@PathVariable Long itemId) {
        Item item = itemRepository.selectByPrimaryKey(itemId);
        return Results.success(item);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        validObject(item);
        itemRepository.insertSelective(item);
        return Results.success(item);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<Item> update(@RequestBody Item item) {
        SecurityTokenHelper.validToken(item);
        itemRepository.updateByPrimaryKeySelective(item);
        return Results.success(item);
    }

    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Item item) {
        SecurityTokenHelper.validToken(item);
        itemRepository.deleteByPrimaryKey(item);
        return Results.success();
    }

}

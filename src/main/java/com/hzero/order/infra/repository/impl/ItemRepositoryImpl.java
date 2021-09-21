package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.entity.Item;
import com.hzero.order.domain.repository.ItemRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

/**
 *  资源库实现
 *
 */
@Component
public class ItemRepositoryImpl extends BaseRepositoryImpl<Item> implements ItemRepository {

  
}

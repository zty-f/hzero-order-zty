package com.hzero.order.config;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务路由配置
 *
 */
@ChoerodonExtraData
class OrderExtraDataManager implements ExtraDataManager {

	@Autowired
	private org.springframework.core.env.Environment environment;

	//@Override
	//public ExtraData getData() {
	//	ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
	//	choerodonRouteData.setName(environment.getProperty("hzero.service.current.name", "zty"));
	//	choerodonRouteData.setPath(environment.getProperty("hzero.service.current.path", "/zty-9527/**"));
	//	choerodonRouteData.setServiceId(environment.getProperty("hzero.service.current.service-name", "hzero-order-zty"));
	//	extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
	//	return extraData;
	//}

	@Override
	public ExtraData getData() {
		ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
		choerodonRouteData.setName(environment.getProperty("hzero.service.current.name", "hodr"));
		choerodonRouteData.setPath(environment.getProperty("hzero.service.current.path", "/hodr/**"));
		choerodonRouteData.setServiceId(environment.getProperty("hzero.service.current.service-name", "hzero-order"));
		extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
		return extraData;
	}
}

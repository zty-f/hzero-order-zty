package com.hzero.order.app.service.impl;

import com.hzero.order.api.utils.PrincipalUtil;
import com.hzero.order.app.remote.RemoteRoleService;
import com.hzero.order.app.service.SoHeaderService;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.oauth.CustomUserDetails;
import org.hzero.core.util.Results;
import org.hzero.iam.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

/**
 * 应用服务默认实现
 *
 */
@Service
public class SoHeaderServiceImpl implements SoHeaderService {
    @Autowired
    private SoHeaderRepository soHeaderRepository;
    @Autowired
    private RemoteRoleService remoteRoleService;

    /**
     * 新建
     */
    public static final String NEW = "NEW";

    /**
     * 已提交
     */
    public static final String SUBMITED = "SUBMITED";

    /**
     * 已审批
     */
    public static final String APPROVED = "APPROVED";

    /**
     * 已拒绝
     */
    public static final String REJECTED = "REJECTED";

    /**
     * 已关闭
     */
    public static final String CLOSED = "CLOSED";

    /**
     * 更改订单的状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> updateStatus(String status, SoHeader soHeader, Principal principal) {
        //通过传过来要修改的ID查询原始的订单头数据
        SoHeader soHeader1 = soHeaderRepository.selectByPrimaryKey(soHeader.getSoHeaderId());
        PrincipalUtil principalUtil = new PrincipalUtil(principal);
        CustomUserDetails details = principalUtil.getDetails();
        Role role = remoteRoleService.queryRoleDetails(details.getOrganizationId(), details.getRoleId());
        switch (status) {
            case SUBMITED:
                if (soHeader1 == null) {
                    //throw new CommonException("");
                    return Results.error("当前订单不存在");
                }
                if (!soHeader1.getCreatedBy().equals(details.getUserId())) {
                    return Results.error("当前用户与创建人不一致");
                }
                if (!REJECTED.equals(soHeader1.getOrderStatus()) && !NEW.equals(soHeader1.getOrderStatus())) {
                    return Results.error("当前订单状态不是NEW或REJECTED");
                }
                break;
            case APPROVED:

            case REJECTED:
                if (soHeader1 == null) {
                    return Results.error("当前订单不存在");
                }
                if (!"sale_manager_201931104202".equals(role.getCode())) {
                    return Results.error("当前角色无法更改订单状态");
                }
                if (!SUBMITED.equals(soHeader1.getOrderStatus())) {
                    return Results.error("当前订单状态不是SUBMITED，无法更改为APPROVED或者REJECTED");
                }
                break;
            default:
                break;
        }
        //不可以对订单编号进行更改
        soHeader.setOrderNumber(soHeader1.getOrderNumber());
        //不必再输入tokenID
        soHeader.set_token(soHeader1.get_token());
        //set相应的Status状态
        //tokenId数据验证
        //SecurityTokenHelper.validToken(soHeader);
        soHeader.setOrderStatus(status);
        soHeaderRepository.updateStatusBySoHeaderId(soHeader);
        return Results.success("修改订单状态成功！");

    }

}

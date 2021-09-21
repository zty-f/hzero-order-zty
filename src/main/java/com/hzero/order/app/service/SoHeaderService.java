package com.hzero.order.app.service;

import com.hzero.order.domain.entity.SoHeader;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

/**
 * 应用服务
 *
 */
public interface SoHeaderService {
     ResponseEntity<String> updateStatus(String status,SoHeader soHeader, Principal principal);
}

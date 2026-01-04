package top.continew.admin.wms.service.impl;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.wms.mapper.SupplierMapper;
import top.continew.admin.wms.model.entity.SupplierDO;
import top.continew.admin.wms.model.req.SupplierReq;
import top.continew.admin.wms.model.resp.SupplierResp;
import top.continew.admin.wms.model.query.SupplierQuery;
import top.continew.admin.wms.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 供应商服务实现类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SupplierServiceImpl extends BaseServiceImpl<SupplierMapper, SupplierDO, SupplierResp, SupplierResp, SupplierQuery, SupplierReq> implements SupplierService {
}
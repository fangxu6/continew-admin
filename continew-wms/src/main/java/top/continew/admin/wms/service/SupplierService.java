package top.continew.admin.wms.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.wms.model.entity.Supplier;
import top.continew.admin.wms.model.req.SupplierReq;
import top.continew.admin.wms.model.resp.SupplierResp;
import top.continew.admin.wms.model.query.SupplierQuery;

/**
 * 供应商服务接口
 *
 * @author 小aron
 * @since 2025/12/30
 */
public interface SupplierService extends BaseService<Supplier, SupplierReq, SupplierResp, SupplierQuery, SupplierReq> {
}
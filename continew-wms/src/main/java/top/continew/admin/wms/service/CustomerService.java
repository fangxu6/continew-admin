package top.continew.admin.wms.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.wms.model.entity.Customer;
import top.continew.admin.wms.model.req.CustomerReq;
import top.continew.admin.wms.model.resp.CustomerResp;
import top.continew.admin.wms.model.query.CustomerQuery;

/**
 * 客户服务接口
 *
 * @author 小aron
 * @since 2025/12/30
 */
public interface CustomerService extends BaseService<Customer, CustomerReq, CustomerResp, CustomerQuery, CustomerReq> {
}
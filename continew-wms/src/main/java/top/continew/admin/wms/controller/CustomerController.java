package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.wms.model.req.CustomerReq;
import top.continew.admin.wms.model.resp.CustomerResp;
import top.continew.admin.wms.model.query.CustomerQuery;
import top.continew.admin.wms.service.CustomerService;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.enums.Api;

/**
 * 客户控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "客户管理 API")
@RestController
@CrudRequestMapping(value = "/wms/customer", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE})
public class CustomerController extends BaseController<CustomerService, CustomerResp, CustomerResp, CustomerQuery, CustomerReq> {
}
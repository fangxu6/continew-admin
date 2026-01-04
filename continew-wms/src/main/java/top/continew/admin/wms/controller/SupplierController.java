package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.wms.model.req.SupplierReq;
import top.continew.admin.wms.model.resp.SupplierResp;
import top.continew.admin.wms.model.query.SupplierQuery;
import top.continew.admin.wms.service.SupplierService;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.enums.Api;

/**
 * 供应商控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "供应商管理 API")
@RestController
@CrudRequestMapping(value = "/wms/supplier", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE})
public class SupplierController extends BaseController<SupplierService, SupplierResp, SupplierResp, SupplierQuery, SupplierReq> {
}
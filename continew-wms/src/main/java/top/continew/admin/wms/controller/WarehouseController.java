package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.wms.model.req.WarehouseReq;
import top.continew.admin.wms.model.resp.WarehouseResp;
import top.continew.admin.wms.model.query.WarehouseQuery;
import top.continew.admin.wms.service.WarehouseService;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.enums.Api;

/**
 * 仓库控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "仓库管理 API")
@RestController
@CrudRequestMapping(value = "/wms/warehouse", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE})
public class WarehouseController extends BaseController<WarehouseService, WarehouseResp, WarehouseResp, WarehouseQuery, WarehouseReq> {
}
package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.wms.model.req.LocationReq;
import top.continew.admin.wms.model.resp.LocationResp;
import top.continew.admin.wms.model.query.LocationQuery;
import top.continew.admin.wms.service.LocationService;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.enums.Api;

/**
 * 位置控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "位置管理 API")
@RestController
@CrudRequestMapping(value = "/wms/location", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE})
public class LocationController extends BaseController<LocationService, LocationResp, LocationResp, LocationQuery, LocationReq> {
}
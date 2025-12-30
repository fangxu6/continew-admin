package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.wms.model.req.LocationReq;
import top.continew.admin.wms.model.resp.LocationResp;
import top.continew.admin.wms.model.query.LocationQuery;
import top.continew.admin.wms.service.LocationService;
import top.continew.starter.core.validation.group.CreateGroup;
import top.continew.starter.core.validation.group.UpdateGroup;

/**
 * 位置控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "位置管理 API")
@RestController
@RequestMapping("/wms/location")
@RequiredArgsConstructor
@Validated
public class LocationController extends WmsBaseController<LocationService, LocationService, LocationQuery, LocationResp, LocationReq> {

    private final LocationService locationService;

    @Override
    public LocationService getService() {
        return locationService;
    }

    @Operation(summary = "创建位置")
    @PostMapping
    public LocationResp create(@Validated(CreateGroup.class) @RequestBody LocationReq req) {
        return locationService.create(req);
    }

    @Operation(summary = "修改位置")
    @PutMapping
    public LocationResp update(@Validated(UpdateGroup.class) @RequestBody LocationReq req) {
        return locationService.update(req);
    }

    @Operation(summary = "删除位置")
    @DeleteMapping("/{id}")
    public void delete(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        locationService.delete(id);
    }

    @Operation(summary = "获取位置详情")
    @GetMapping("/{id}")
    public LocationResp get(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        return locationService.get(id);
    }

    @Operation(summary = "分页查询位置")
    @GetMapping("/page")
    public LocationResp page(LocationQuery query) {
        return locationService.page(query);
    }
}
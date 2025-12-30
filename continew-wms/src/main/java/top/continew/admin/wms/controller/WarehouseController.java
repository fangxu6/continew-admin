package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.wms.model.req.WarehouseReq;
import top.continew.admin.wms.model.resp.WarehouseResp;
import top.continew.admin.wms.model.query.WarehouseQuery;
import top.continew.admin.wms.service.WarehouseService;
import top.continew.starter.core.validation.group.CreateGroup;
import top.continew.starter.core.validation.group.UpdateGroup;

/**
 * 仓库控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "仓库管理 API")
@RestController
@RequestMapping("/wms/warehouse")
@RequiredArgsConstructor
@Validated
public class WarehouseController extends WmsBaseController<WarehouseService, WarehouseService, WarehouseQuery, WarehouseResp, WarehouseReq> {

    private final WarehouseService warehouseService;

    @Override
    public WarehouseService getService() {
        return warehouseService;
    }

    @Operation(summary = "创建仓库")
    @PostMapping
    public WarehouseResp create(@Validated(CreateGroup.class) @RequestBody WarehouseReq req) {
        return warehouseService.create(req);
    }

    @Operation(summary = "修改仓库")
    @PutMapping
    public WarehouseResp update(@Validated(UpdateGroup.class) @RequestBody WarehouseReq req) {
        return warehouseService.update(req);
    }

    @Operation(summary = "删除仓库")
    @DeleteMapping("/{id}")
    public void delete(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        warehouseService.delete(id);
    }

    @Operation(summary = "获取仓库详情")
    @GetMapping("/{id}")
    public WarehouseResp get(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        return warehouseService.get(id);
    }

    @Operation(summary = "分页查询仓库")
    @GetMapping("/page")
    public WarehouseResp page(WarehouseQuery query) {
        return warehouseService.page(query);
    }
}
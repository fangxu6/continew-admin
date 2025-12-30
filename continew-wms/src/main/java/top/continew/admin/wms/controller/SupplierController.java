package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.wms.model.req.SupplierReq;
import top.continew.admin.wms.model.resp.SupplierResp;
import top.continew.admin.wms.model.query.SupplierQuery;
import top.continew.admin.wms.service.SupplierService;
import top.continew.starter.core.validation.group.CreateGroup;
import top.continew.starter.core.validation.group.UpdateGroup;

/**
 * 供应商控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "供应商管理 API")
@RestController
@RequestMapping("/wms/supplier")
@RequiredArgsConstructor
@Validated
public class SupplierController extends WmsBaseController<SupplierService, SupplierService, SupplierQuery, SupplierResp, SupplierReq> {

    private final SupplierService supplierService;

    @Override
    public SupplierService getService() {
        return supplierService;
    }

    @Operation(summary = "创建供应商")
    @PostMapping
    public SupplierResp create(@Validated(CreateGroup.class) @RequestBody SupplierReq req) {
        return supplierService.create(req);
    }

    @Operation(summary = "修改供应商")
    @PutMapping
    public SupplierResp update(@Validated(UpdateGroup.class) @RequestBody SupplierReq req) {
        return supplierService.update(req);
    }

    @Operation(summary = "删除供应商")
    @DeleteMapping("/{id}")
    public void delete(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        supplierService.delete(id);
    }

    @Operation(summary = "获取供应商详情")
    @GetMapping("/{id}")
    public SupplierResp get(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        return supplierService.get(id);
    }

    @Operation(summary = "分页查询供应商")
    @GetMapping("/page")
    public SupplierResp page(SupplierQuery query) {
        return supplierService.page(query);
    }
}
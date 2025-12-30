package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.wms.model.req.CustomerReq;
import top.continew.admin.wms.model.resp.CustomerResp;
import top.continew.admin.wms.model.query.CustomerQuery;
import top.continew.admin.wms.service.CustomerService;
import top.continew.starter.core.validation.group.CreateGroup;
import top.continew.starter.core.validation.group.UpdateGroup;

/**
 * 客户控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "客户管理 API")
@RestController
@RequestMapping("/wms/customer")
@RequiredArgsConstructor
@Validated
public class CustomerController extends WmsBaseController<CustomerService, CustomerService, CustomerQuery, CustomerResp, CustomerReq> {

    private final CustomerService customerService;

    @Override
    public CustomerService getService() {
        return customerService;
    }

    @Operation(summary = "创建客户")
    @PostMapping
    public CustomerResp create(@Validated(CreateGroup.class) @RequestBody CustomerReq req) {
        return customerService.create(req);
    }

    @Operation(summary = "修改客户")
    @PutMapping
    public CustomerResp update(@Validated(UpdateGroup.class) @RequestBody CustomerReq req) {
        return customerService.update(req);
    }

    @Operation(summary = "删除客户")
    @DeleteMapping("/{id}")
    public void delete(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        customerService.delete(id);
    }

    @Operation(summary = "获取客户详情")
    @GetMapping("/{id}")
    public CustomerResp get(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        return customerService.get(id);
    }

    @Operation(summary = "分页查询客户")
    @GetMapping("/page")
    public CustomerResp page(CustomerQuery query) {
        return customerService.page(query);
    }
}
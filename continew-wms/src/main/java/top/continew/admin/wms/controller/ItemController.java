package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.wms.model.req.ItemReq;
import top.continew.admin.wms.model.resp.ItemResp;
import top.continew.admin.wms.model.query.ItemQuery;
import top.continew.admin.wms.service.ItemService;
import top.continew.starter.core.validation.group.CreateGroup;
import top.continew.starter.core.validation.group.UpdateGroup;

/**
 * 物品控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "物品管理 API")
@RestController
@RequestMapping("/wms/item")
@RequiredArgsConstructor
@Validated
public class ItemController extends WmsBaseController<ItemService, ItemService, ItemQuery, ItemResp, ItemReq> {

    private final ItemService itemService;

    @Override
    public ItemService getService() {
        return itemService;
    }

    @Operation(summary = "创建物品")
    @PostMapping
    public ItemResp create(@Validated(CreateGroup.class) @RequestBody ItemReq req) {
        return itemService.create(req);
    }

    @Operation(summary = "修改物品")
    @PutMapping
    public ItemResp update(@Validated(UpdateGroup.class) @RequestBody ItemReq req) {
        return itemService.update(req);
    }

    @Operation(summary = "删除物品")
    @DeleteMapping("/{id}")
    public void delete(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        itemService.delete(id);
    }

    @Operation(summary = "获取物品详情")
    @GetMapping("/{id}")
    public ItemResp get(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        return itemService.get(id);
    }

    @Operation(summary = "分页查询物品")
    @GetMapping("/page")
    public ItemResp page(ItemQuery query) {
        return itemService.page(query);
    }
}
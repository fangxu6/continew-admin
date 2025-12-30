package top.continew.admin.wms.controller;

import top.continew.admin.common.base.controller.BaseController;
import top.continew.starter.core.validation.group.CreateGroup;
import top.continew.starter.core.validation.group.UpdateGroup;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.util.StrUtil;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * WMS模块基础控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Validated
public abstract class WmsBaseController<T, S, Q, R, U> extends BaseController<S, R, R, Q, U> {

    /**
     * 创建
     */
    @PostMapping
    @SaCheckPermission("sys:wms:create")
    public R create(@Validated(CreateGroup.class) @RequestBody R req) {
        return service.create(req);
    }

    /**
     * 修改
     */
    @PutMapping
    @SaCheckPermission("sys:wms:update")
    public R update(@Validated(UpdateGroup.class) @RequestBody U req) {
        return service.update(req);
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    @SaCheckPermission("sys:wms:delete")
    public void delete(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        service.delete(id);
    }

    /**
     * 获取详情
     */
    @GetMapping("/{id}")
    @SaCheckPermission("sys:wms:query")
    public R get(@NotNull(message = "ID不能为空") @PathVariable Long id) {
        return service.get(id);
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    @SaCheckPermission("sys:wms:query")
    public R page(Q query) {
        if (StrUtil.isNotBlank(query.getKeyword())) {
            query.setKeyword("%" + query.getKeyword() + "%");
        }
        return service.page(query);
    }
}
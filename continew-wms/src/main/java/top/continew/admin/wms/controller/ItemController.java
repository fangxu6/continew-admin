package top.continew.admin.wms.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.wms.model.req.ItemReq;
import top.continew.admin.wms.model.resp.ItemResp;
import top.continew.admin.wms.model.query.ItemQuery;
import top.continew.admin.wms.service.ItemService;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.enums.Api;

/**
 * 物品控制器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Tag(name = "物品管理 API")
@RestController
@CrudRequestMapping(value = "/wms/item", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE})
public class ItemController extends BaseController<ItemService, ItemResp, ItemResp, ItemQuery, ItemReq> {
}
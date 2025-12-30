package top.continew.admin.wms.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.wms.model.entity.Item;
import top.continew.admin.wms.model.req.ItemReq;
import top.continew.admin.wms.model.resp.ItemResp;
import top.continew.admin.wms.model.query.ItemQuery;

/**
 * 物品服务接口
 *
 * @author 小aron
 * @since 2025/12/30
 */
public interface ItemService extends BaseService<Item, ItemReq, ItemResp, ItemQuery, ItemReq> {
}
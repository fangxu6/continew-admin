package top.continew.admin.wms.service.impl;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.wms.mapper.ItemMapper;
import top.continew.admin.wms.model.entity.ItemDO;
import top.continew.admin.wms.model.req.ItemReq;
import top.continew.admin.wms.model.resp.ItemResp;
import top.continew.admin.wms.model.query.ItemQuery;
import top.continew.admin.wms.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 物品服务实现类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl extends BaseServiceImpl<ItemMapper, ItemDO, ItemResp, ItemResp, ItemQuery, ItemReq> implements ItemService {
}
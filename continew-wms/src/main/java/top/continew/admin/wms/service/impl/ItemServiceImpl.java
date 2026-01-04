package top.continew.admin.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

    @Override
    public LambdaQueryWrapper<ItemDO> getWrapper(ItemQuery query) {
        return Wrappers.<ItemDO>lambdaQuery()
            .like(query.getCode() != null, ItemDO::getCode, query.getCode())
            .like(query.getName() != null, ItemDO::getName, query.getName())
            .eq(query.getCategory() != null, ItemDO::getCategory, query.getCategory())
            .eq(query.getStatus() != null, ItemDO::getStatus, query.getStatus());
    }
}
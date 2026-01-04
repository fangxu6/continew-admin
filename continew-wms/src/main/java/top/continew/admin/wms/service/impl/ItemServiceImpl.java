package top.continew.admin.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.StrUtil;
import top.continew.admin.wms.convert.ItemConvert;
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
public class ItemServiceImpl extends ServiceImpl<ItemMapper, ItemDO> implements ItemService {

    @Override
    public ItemResp get(Long id) {
        ItemDO entity = this.getById(id);
        return ItemConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public ItemResp create(ItemReq req) {
        ItemDO entity = ItemConvert.INSTANCE.req2Entity(req);
        this.save(entity);
        return ItemConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public ItemResp update(ItemReq req) {
        ItemDO entity = ItemConvert.INSTANCE.req2Entity(req);
        this.updateById(entity);
        return ItemConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }

    @Override
    public LambdaQueryWrapper<ItemDO> getWrapper(ItemQuery query) {
        return Wrappers.<ItemDO>lambdaQuery()
            .like(StrUtil.isNotBlank(query.getCode()), ItemDO::getCode, query.getCode())
            .like(StrUtil.isNotBlank(query.getName()), ItemDO::getName, query.getName())
            .eq(StrUtil.isNotBlank(query.getCategory()), ItemDO::getCategory, query.getCategory())
            .eq(StrUtil.isNotBlank(query.getStatus()), ItemDO::getStatus, query.getStatus());
    }
}
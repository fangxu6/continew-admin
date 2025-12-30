package top.continew.admin.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.StrUtil;
import top.continew.admin.wms.convert.WarehouseConvert;
import top.continew.admin.wms.mapper.WarehouseMapper;
import top.continew.admin.wms.model.entity.Warehouse;
import top.continew.admin.wms.model.req.WarehouseReq;
import top.continew.admin.wms.model.resp.WarehouseResp;
import top.continew.admin.wms.model.query.WarehouseQuery;
import top.continew.admin.wms.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 仓库服务实现类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {

    @Override
    public WarehouseResp get(Long id) {
        Warehouse entity = this.getById(id);
        return WarehouseConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public WarehouseResp create(WarehouseReq req) {
        Warehouse entity = WarehouseConvert.INSTANCE.req2Entity(req);
        this.save(entity);
        return WarehouseConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public WarehouseResp update(WarehouseReq req) {
        Warehouse entity = WarehouseConvert.INSTANCE.req2Entity(req);
        this.updateById(entity);
        return WarehouseConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }

    @Override
    public LambdaQueryWrapper<Warehouse> getWrapper(WarehouseQuery query) {
        return Wrappers.<Warehouse>lambdaQuery()
            .like(StrUtil.isNotBlank(query.getCode()), Warehouse::getCode, query.getCode())
            .like(StrUtil.isNotBlank(query.getName()), Warehouse::getName, query.getName())
            .eq(StrUtil.isNotBlank(query.getStatus()), Warehouse::getStatus, query.getStatus());
    }
}
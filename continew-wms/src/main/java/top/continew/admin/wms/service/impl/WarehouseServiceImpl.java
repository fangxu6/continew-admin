package top.continew.admin.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.wms.mapper.WarehouseMapper;
import top.continew.admin.wms.model.entity.WarehouseDO;
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
public class WarehouseServiceImpl extends BaseServiceImpl<WarehouseMapper, WarehouseDO, WarehouseResp, WarehouseResp, WarehouseQuery, WarehouseReq> implements WarehouseService {

    @Override
    public LambdaQueryWrapper<WarehouseDO> getWrapper(WarehouseQuery query) {
        return Wrappers.<WarehouseDO>lambdaQuery()
            .like(query.getCode() != null, WarehouseDO::getCode, query.getCode())
            .like(query.getName() != null, WarehouseDO::getName, query.getName())
            .eq(query.getStatus() != null, WarehouseDO::getStatus, query.getStatus());
    }
}
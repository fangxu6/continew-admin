package top.continew.admin.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.wms.mapper.LocationMapper;
import top.continew.admin.wms.model.entity.LocationDO;
import top.continew.admin.wms.model.req.LocationReq;
import top.continew.admin.wms.model.resp.LocationResp;
import top.continew.admin.wms.model.query.LocationQuery;
import top.continew.admin.wms.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 位置服务实现类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LocationServiceImpl extends BaseServiceImpl<LocationMapper, LocationDO, LocationResp, LocationResp, LocationQuery, LocationReq> implements LocationService {

    @Override
    public LambdaQueryWrapper<LocationDO> getWrapper(LocationQuery query) {
        return Wrappers.<LocationDO>lambdaQuery()
            .like(query.getCode() != null, LocationDO::getCode, query.getCode())
            .like(query.getName() != null, LocationDO::getName, query.getName())
            .eq(query.getWarehouseId() != null, LocationDO::getWarehouseId, query.getWarehouseId())
            .eq(query.getType() != null, LocationDO::getType, query.getType())
            .eq(query.getStatus() != null, LocationDO::getStatus, query.getStatus());
    }
}
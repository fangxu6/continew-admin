package top.continew.admin.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.StrUtil;
import top.continew.admin.wms.convert.LocationConvert;
import top.continew.admin.wms.mapper.LocationMapper;
import top.continew.admin.wms.model.entity.Location;
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
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements LocationService {

    @Override
    public LocationResp get(Long id) {
        Location entity = this.getById(id);
        return LocationConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public LocationResp create(LocationReq req) {
        Location entity = LocationConvert.INSTANCE.req2Entity(req);
        this.save(entity);
        return LocationConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public LocationResp update(LocationReq req) {
        Location entity = LocationConvert.INSTANCE.req2Entity(req);
        this.updateById(entity);
        return LocationConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }

    @Override
    public LambdaQueryWrapper<Location> getWrapper(LocationQuery query) {
        return Wrappers.<Location>lambdaQuery()
            .like(StrUtil.isNotBlank(query.getCode()), Location::getCode, query.getCode())
            .like(StrUtil.isNotBlank(query.getName()), Location::getName, query.getName())
            .eq(query.getWarehouseId() != null, Location::getWarehouseId, query.getWarehouseId())
            .eq(StrUtil.isNotBlank(query.getType()), Location::getType, query.getType())
            .eq(StrUtil.isNotBlank(query.getStatus()), Location::getStatus, query.getStatus());
    }
}
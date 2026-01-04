package top.continew.admin.wms.service.impl;

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
}
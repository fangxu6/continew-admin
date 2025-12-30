package top.continew.admin.wms.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.wms.model.entity.Location;
import top.continew.admin.wms.model.req.LocationReq;
import top.continew.admin.wms.model.resp.LocationResp;
import top.continew.admin.wms.model.query.LocationQuery;

/**
 * 位置服务接口
 *
 * @author 小aron
 * @since 2025/12/30
 */
public interface LocationService extends BaseService<Location, LocationReq, LocationResp, LocationQuery, LocationReq> {
}
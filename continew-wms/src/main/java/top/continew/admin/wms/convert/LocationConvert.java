package top.continew.admin.wms.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.continew.admin.wms.model.entity.LocationDO;
import top.continew.admin.wms.model.req.LocationReq;
import top.continew.admin.wms.model.resp.LocationResp;

/**
 * 位置转换器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Mapper
public interface LocationConvert {

    LocationConvert INSTANCE = Mappers.getMapper(LocationConvert.class);

    @Mapping(target = "id", ignore = true)
	LocationDO req2Entity(LocationReq req);

    LocationResp entity2Resp(LocationDO entity);
}
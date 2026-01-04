package top.continew.admin.wms.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.continew.admin.wms.model.entity.WarehouseDO;
import top.continew.admin.wms.model.req.WarehouseReq;
import top.continew.admin.wms.model.resp.WarehouseResp;

/**
 * 仓库转换器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Mapper
public interface WarehouseConvert {

    WarehouseConvert INSTANCE = Mappers.getMapper(WarehouseConvert.class);

    @Mapping(target = "id", ignore = true)
	WarehouseDO req2Entity(WarehouseReq req);

    WarehouseResp entity2Resp(WarehouseDO entity);
}
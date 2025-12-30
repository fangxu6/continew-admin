package top.continew.admin.wms.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.continew.admin.wms.model.entity.Supplier;
import top.continew.admin.wms.model.req.SupplierReq;
import top.continew.admin.wms.model.resp.SupplierResp;

/**
 * 供应商转换器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Mapper
public interface SupplierConvert {

    SupplierConvert INSTANCE = Mappers.getMapper(SupplierConvert.class);

    @Mapping(target = "id", ignore = true)
    Supplier req2Entity(SupplierReq req);

    SupplierResp entity2Resp(Supplier entity);
}
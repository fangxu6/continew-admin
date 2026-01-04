package top.continew.admin.wms.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.continew.admin.wms.model.entity.CustomerDO;
import top.continew.admin.wms.model.req.CustomerReq;
import top.continew.admin.wms.model.resp.CustomerResp;

/**
 * 客户转换器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Mapper
public interface CustomerConvert {

    CustomerConvert INSTANCE = Mappers.getMapper(CustomerConvert.class);

    @Mapping(target = "id", ignore = true)
	CustomerDO req2Entity(CustomerReq req);

    CustomerResp entity2Resp(CustomerDO entity);
}
package top.continew.admin.wms.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.continew.admin.wms.model.entity.ItemDO;
import top.continew.admin.wms.model.req.ItemReq;
import top.continew.admin.wms.model.resp.ItemResp;

/**
 * 物品转换器
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Mapper
public interface ItemConvert {

    ItemConvert INSTANCE = Mappers.getMapper(ItemConvert.class);

    @Mapping(target = "id", ignore = true)
	ItemDO req2Entity(ItemReq req);

    ItemResp entity2Resp(ItemDO entity);
}
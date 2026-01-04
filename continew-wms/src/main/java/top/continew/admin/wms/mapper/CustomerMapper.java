package top.continew.admin.wms.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.wms.model.entity.CustomerDO;
import top.continew.starter.data.mapper.BaseMapper;

/**
 * 客户Mapper接口
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Mapper
public interface CustomerMapper extends BaseMapper<CustomerDO> {
}
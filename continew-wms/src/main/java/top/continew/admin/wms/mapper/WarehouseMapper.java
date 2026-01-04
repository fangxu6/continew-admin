package top.continew.admin.wms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.wms.model.entity.WarehouseDO;

/**
 * 仓库Mapper接口
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Mapper
public interface WarehouseMapper extends BaseMapper<WarehouseDO> {
}
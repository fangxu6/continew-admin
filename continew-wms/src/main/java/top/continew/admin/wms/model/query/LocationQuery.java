package top.continew.admin.wms.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.base.model.BasePageQuery;

/**
 * 位置查询条件
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "位置查询条件")
public class LocationQuery extends BasePageQuery {

    @Schema(description = "位置编码")
    private String code;

    @Schema(description = "位置名称")
    private String name;

    @Schema(description = "所属仓库ID")
    private Long warehouseId;

    @Schema(description = "位置类型: 存储/拣选/暂存等")
    private String type;

    @Schema(description = "位置状态: 可用/不可用/锁定")
    private String status;
}
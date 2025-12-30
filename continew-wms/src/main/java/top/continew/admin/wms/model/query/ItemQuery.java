package top.continew.admin.wms.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.base.model.BasePageQuery;

/**
 * 物品查询条件
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "物品查询条件")
public class ItemQuery extends BasePageQuery {

    @Schema(description = "物品编码")
    private String code;

    @Schema(description = "物品名称")
    private String name;

    @Schema(description = "物品类别")
    private String category;

    @Schema(description = "物品状态: 启用/禁用")
    private String status;
}
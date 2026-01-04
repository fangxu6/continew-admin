package top.continew.admin.wms.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;

/**
 * 物品查询条件
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "物品查询条件")
public class ItemQuery implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "物品编码")
    @Query
    private String code;

    @Schema(description = "物品名称")
    @Query(columns = "name", type = QueryType.LIKE)
    private String name;

    @Schema(description = "物品类别")
    @Query
    private String category;

    @Schema(description = "物品状态: 启用/禁用")
    @Query
    private String status;
}
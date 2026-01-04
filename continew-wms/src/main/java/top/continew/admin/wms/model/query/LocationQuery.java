package top.continew.admin.wms.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;

/**
 * 位置查询条件
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "位置查询条件")
public class LocationQuery implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "位置编码")
    @Query
    private String code;

    @Schema(description = "位置名称")
    @Query(columns = "name", type = QueryType.LIKE)
    private String name;

    @Schema(description = "所属仓库ID")
    @Query
    private Long warehouseId;

    @Schema(description = "位置类型: 存储/拣选/暂存等")
    @Query
    private String type;

    @Schema(description = "位置状态: 可用/不可用/锁定")
    @Query
    private String status;
}
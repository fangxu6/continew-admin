package top.continew.admin.wms.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;

/**
 * 仓库查询条件
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "仓库查询条件")
public class WarehouseQuery  implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "仓库编码")
    @Query
    private String code;

    @Schema(description = "仓库名称")
    @Query(columns = "name", type = QueryType.LIKE)
    private String name;

    @Schema(description = "仓库地址")
    @Query(columns = "address", type = QueryType.LIKE)
    private String address;

    @Schema(description = "仓库管理员")
    @Query(columns = "manager", type = QueryType.LIKE)
    private String manager;

    @Schema(description = "仓库管理员ID")
    @Query
    private Long managerId;

    @Schema(description = "仓库状态: ENABLE-启用, DISABLE-禁用")
    @Query
    private String status;
}
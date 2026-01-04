package top.continew.admin.wms.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;

/**
 * 供应商查询条件
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "供应商查询条件")
public class SupplierQuery implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "供应商编码")
    @Query
    private String code;

    @Schema(description = "供应商名称")
    @Query(columns = "name", type = QueryType.LIKE)
    private String name;

    @Schema(description = "供应商状态: 合作中/已终止")
    @Query
    private String status;
}
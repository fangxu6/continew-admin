package top.continew.admin.wms.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;

/**
 * 客户查询条件
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "客户查询条件")
public class CustomerQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "客户编码")
    @Query
    private String code;

    @Schema(description = "客户名称")
    @Query(columns = "name", type = QueryType.LIKE)
    private String name;

    @Schema(description = "客户状态: 合作中/已终止")
    @Query
    private String status;
}
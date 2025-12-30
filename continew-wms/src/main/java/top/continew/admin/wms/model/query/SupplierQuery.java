package top.continew.admin.wms.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.base.model.BasePageQuery;

/**
 * 供应商查询条件
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "供应商查询条件")
public class SupplierQuery extends BasePageQuery {

    @Schema(description = "供应商编码")
    private String code;

    @Schema(description = "供应商名称")
    private String name;

    @Schema(description = "供应商状态: 合作中/已终止")
    private String status;
}
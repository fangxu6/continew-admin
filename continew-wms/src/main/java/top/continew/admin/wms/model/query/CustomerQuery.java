package top.continew.admin.wms.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.base.model.BasePageQuery;

/**
 * 客户查询条件
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "客户查询条件")
public class CustomerQuery extends BasePageQuery {

    @Schema(description = "客户编码")
    private String code;

    @Schema(description = "客户名称")
    private String name;

    @Schema(description = "客户状态: 合作中/已终止")
    private String status;
}
package top.continew.admin.wms.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 物品请求参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "物品请求参数")
public class ItemReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    @NotNull(message = "ID不能为空")
    private Long id;

    @Schema(description = "物品编码", required = true)
    @NotBlank(message = "物品编码不能为空")
    private String code;

    @Schema(description = "物品名称", required = true)
    @NotBlank(message = "物品名称不能为空")
    private String name;

    @Schema(description = "物品描述")
    private String description;

    @Schema(description = "物品类别")
    private String category;

    @Schema(description = "计量单位", required = true)
    @NotBlank(message = "计量单位不能为空")
    private String unit;

    @Schema(description = "长度")
    private BigDecimal length;

    @Schema(description = "宽度")
    private BigDecimal width;

    @Schema(description = "高度")
    private BigDecimal height;

    @Schema(description = "重量")
    private BigDecimal weight;

    @Schema(description = "物品状态: 启用/禁用")
    private String status;
}
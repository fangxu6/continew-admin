package top.continew.admin.wms.model.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 物品响应参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "物品响应参数")
public class ItemResp {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "物品编码")
    private String code;

    @Schema(description = "物品名称")
    private String name;

    @Schema(description = "物品描述")
    private String description;

    @Schema(description = "物品类别")
    private String category;

    @Schema(description = "计量单位")
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

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "创建人")
    private Long createBy;

    @Schema(description = "更新人")
    private Long updateBy;
}
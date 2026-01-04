package top.continew.admin.wms.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import top.continew.starter.core.validation.group.CreateGroup;
import top.continew.starter.core.validation.group.UpdateGroup;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 位置请求参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "位置请求参数")
public class LocationReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    @NotNull(message = "ID不能为空")
    private Long id;

    @Schema(description = "位置编码", required = true)
    @NotBlank(message = "位置编码不能为空")
    private String code;

    @Schema(description = "位置名称", required = true)
    @NotBlank(message = "位置名称不能为空")
    private String name;

    @Schema(description = "所属仓库ID", required = true)
    @NotNull(message = "所属仓库ID不能为空")
    private Long warehouseId;

    @Schema(description = "所属区域")
    private String area;

    @Schema(description = "排")
    private String row;

    @Schema(description = "列")
    private String column;

    @Schema(description = "层")
    private String level;

    @Schema(description = "位")
    private String position;

    @Schema(description = "位置类型: 存储/拣选/暂存等")
    private String type;

    @Schema(description = "容量")
    private BigDecimal capacity;

    @Schema(description = "位置状态: 可用/不可用/锁定")
    private String status;

    @Schema(description = "备注")
    private String remark;
}
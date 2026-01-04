package top.continew.admin.wms.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 仓库请求参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "仓库请求参数")
public class WarehouseReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    @NotNull(message = "ID不能为空")
    private Long id;

    @Schema(description = "仓库编码", required = true)
    @NotBlank(message = "仓库编码不能为空")
    private String code;

    @Schema(description = "仓库名称", required = true)
    @NotBlank(message = "仓库名称不能为空")
    private String name;

    @Schema(description = "仓库地址")
    private String address;

    @Schema(description = "仓库类型: 普通仓/冷藏仓/危险品仓等")
    private String type;

    @Schema(description = "仓库状态: 启用/禁用")
    private String status;

    @Schema(description = "负责人")
    private String manager;

    @Schema(description = "联系电话")
    private String phone;

    @Schema(description = "备注")
    private String remark;
}
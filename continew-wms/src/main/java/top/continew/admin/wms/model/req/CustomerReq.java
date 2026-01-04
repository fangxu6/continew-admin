package top.continew.admin.wms.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 客户请求参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "客户请求参数")
public class CustomerReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    @NotNull(message = "ID不能为空")
    private Long id;

    @Schema(description = "客户编码", required = true)
    @NotBlank(message = "客户编码不能为空")
    private String code;

    @Schema(description = "客户名称", required = true)
    @NotBlank(message = "客户名称不能为空")
    private String name;

    @Schema(description = "联系人")
    private String contact;

    @Schema(description = "联系电话")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "客户状态: 合作中/已终止")
    private String status;

    @Schema(description = "信用等级")
    private String creditLevel;

    @Schema(description = "备注")
    private String remark;
}
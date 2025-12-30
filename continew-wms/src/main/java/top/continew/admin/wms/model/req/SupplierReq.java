package top.continew.admin.wms.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import top.continew.starter.core.validation.group.CreateGroup;
import top.continew.starter.core.validation.group.UpdateGroup;

/**
 * 供应商请求参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "供应商请求参数")
public class SupplierReq {

    @Schema(description = "ID")
    @NotNull(message = "ID不能为空", groups = UpdateGroup.class)
    private Long id;

    @Schema(description = "供应商编码", required = true)
    @NotBlank(message = "供应商编码不能为空", groups = {CreateGroup.class, UpdateGroup.class})
    private String code;

    @Schema(description = "供应商名称", required = true)
    @NotBlank(message = "供应商名称不能为空", groups = {CreateGroup.class, UpdateGroup.class})
    private String name;

    @Schema(description = "联系人")
    private String contact;

    @Schema(description = "联系电话")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "供应商状态: 合作中/已终止")
    private String status;

    @Schema(description = "信用等级")
    private String creditLevel;

    @Schema(description = "备注")
    private String remark;
}
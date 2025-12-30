package top.continew.admin.wms.model.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 供应商响应参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@Schema(description = "供应商响应参数")
public class SupplierResp {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "供应商编码")
    private String code;

    @Schema(description = "供应商名称")
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

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "创建人")
    private Long createBy;

    @Schema(description = "更新人")
    private Long updateBy;
}
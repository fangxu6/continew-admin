package top.continew.admin.wms.model.resp;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.base.model.resp.BaseDetailResp;

import java.io.Serial;

/**
 * 客户响应参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "客户响应参数")
public class CustomerResp  extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "客户编码")
    private String code;

    @Schema(description = "客户名称")
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
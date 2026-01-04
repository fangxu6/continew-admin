package top.continew.admin.wms.model.resp;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.base.model.resp.BaseDetailResp;

import java.io.Serial;

/**
 * 仓库响应参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "仓库响应参数")
public class WarehouseResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "仓库编码")
    private String code;

    @Schema(description = "仓库名称")
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
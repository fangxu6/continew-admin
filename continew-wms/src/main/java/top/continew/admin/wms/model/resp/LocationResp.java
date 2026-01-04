package top.continew.admin.wms.model.resp;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.base.model.resp.BaseDetailResp;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 位置响应参数
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "位置响应参数")
public class LocationResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "位置编码")
    private String code;

    @Schema(description = "位置名称")
    private String name;

    @Schema(description = "所属仓库ID")
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

    @Schema(description = "已用容量")
    private BigDecimal usedCapacity;

    @Schema(description = "位置状态: 可用/不可用/锁定")
    private String status;

    @Schema(description = "备注")
    private String remark;
}
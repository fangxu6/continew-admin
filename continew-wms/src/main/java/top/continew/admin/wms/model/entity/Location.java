package top.continew.admin.wms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import top.continew.admin.common.base.model.BaseDO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 位置实体
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@TableName("wms_location")
public class Location extends BaseDO {
    
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
     * 位置编码，唯一，必填
     */
    private String code;
    
    /**
     * 位置名称，必填
     */
    private String name;
    
    /**
     * 所属仓库ID，必填
     */
    private Long warehouseId;
    
    /**
     * 所属区域
     */
    private String area;
    
    /**
     * 排
     */
    private String row;
    
    /**
     * 列
     */
    private String column;
    
    /**
     * 层
     */
    private String level;
    
    /**
     * 位
     */
    private String position;
    
    /**
     * 位置类型: 存储/拣选/暂存等
     */
    private String type;
    
    /**
     * 容量
     */
    private BigDecimal capacity;
    
    /**
     * 已用容量
     */
    private BigDecimal usedCapacity;
    
    /**
     * 位置状态: 可用/不可用/锁定
     */
    private String status;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 创建人
     */
    private Long createBy;
    
    /**
     * 更新人
     */
    private Long updateBy;
}
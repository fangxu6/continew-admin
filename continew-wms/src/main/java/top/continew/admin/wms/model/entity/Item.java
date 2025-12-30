package top.continew.admin.wms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import top.continew.admin.common.base.model.BaseDO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 物品实体
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@TableName("wms_item")
public class Item extends BaseDO {
    
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
     * 物品编码，唯一，必填
     */
    private String code;
    
    /**
     * 物品名称，必填
     */
    private String name;
    
    /**
     * 物品描述
     */
    private String description;
    
    /**
     * 物品类别
     */
    private String category;
    
    /**
     * 计量单位
     */
    private String unit;
    
    /**
     * 长度
     */
    private BigDecimal length;
    
    /**
     * 宽度
     */
    private BigDecimal width;
    
    /**
     * 高度
     */
    private BigDecimal height;
    
    /**
     * 重量
     */
    private BigDecimal weight;
    
    /**
     * 物品状态: 启用/禁用
     */
    private String status;
    
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
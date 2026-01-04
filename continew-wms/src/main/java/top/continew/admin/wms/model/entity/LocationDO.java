package top.continew.admin.wms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import top.continew.admin.common.base.model.entity.BaseDO;

import java.io.Serial;
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
public class LocationDO extends BaseDO {
	
	@Serial
    private static final long serialVersionUID = 1L;

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
     * 位置类型: STORAGE-存储, PICKING-拣选, RECEIVING-收货, SHIPPING-发货
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
     * 位置状态: AVAILABLE-可用, UNAVAILABLE-不可用, LOCKED-锁定
     */
    private String status;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 软删除标记: 0-未删除, 1-已删除
     */
    @TableLogic
    private Boolean deleted;
    
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
    private Long createUser;
    
    /**
     * 更新人
     */
    private Long updateUser;
}
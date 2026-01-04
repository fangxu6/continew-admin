package top.continew.admin.wms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import top.continew.admin.common.base.model.entity.BaseDO;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 仓库实体
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@TableName("wms_warehouse")
public class WarehouseDO extends BaseDO {
	
	@Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
     * 仓库编码，唯一，必填
     */
    private String code;
    
    /**
     * 仓库名称，必填
     */
    private String name;
    
    /**
     * 仓库地址
     */
    private String address;
    
    /**
     * 仓库管理员
     */
    private String manager;
    
    /**
     * 仓库管理员ID
     */
    private Long managerId;
    
    /**
     * 仓库状态: ENABLE-启用, DISABLE-禁用
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
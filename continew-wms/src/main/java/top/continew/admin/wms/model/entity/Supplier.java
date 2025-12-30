package top.continew.admin.wms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import top.continew.admin.common.base.model.BaseDO;

import java.time.LocalDateTime;

/**
 * 供应商实体
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Data
@TableName("wms_supplier")
public class Supplier extends BaseDO {
    
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
     * 供应商编码，唯一，必填
     */
    private String code;
    
    /**
     * 供应商名称，必填
     */
    private String name;
    
    /**
     * 联系人
     */
    private String contact;
    
    /**
     * 联系电话
     */
    private String phone;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 地址
     */
    private String address;
    
    /**
     * 供应商状态: 合作中/已终止
     */
    private String status;
    
    /**
     * 信用等级
     */
    private String creditLevel;
    
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
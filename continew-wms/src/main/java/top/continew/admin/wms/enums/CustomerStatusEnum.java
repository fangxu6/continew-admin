package top.continew.admin.wms.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 客户状态枚举
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Getter
@AllArgsConstructor
public enum CustomerStatusEnum {

    /**
     * 合作中
     */
    COOPERATING("COOPERATING", "合作中"),

    /**
     * 已终止
     */
    TERMINATED("TERMINATED", "已终止");

    @EnumValue
    @JsonValue
    private final String code;
    private final String desc;
}
package top.continew.admin.wms.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 位置状态枚举
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Getter
@AllArgsConstructor
public enum LocationStatusEnum {

    /**
     * 可用
     */
    AVAILABLE("AVAILABLE", "可用"),

    /**
     * 不可用
     */
    UNAVAILABLE("UNAVAILABLE", "不可用"),

    /**
     * 锁定
     */
    LOCKED("LOCKED", "锁定");

    @EnumValue
    @JsonValue
    private final String code;
    private final String desc;
}
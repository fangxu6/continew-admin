package top.continew.admin.wms.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 仓库状态枚举
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Getter
@AllArgsConstructor
public enum WarehouseStatusEnum {

    /**
     * 启用
     */
    ENABLE("ENABLE", "启用"),

    /**
     * 禁用
     */
    DISABLE("DISABLE", "禁用");

    @EnumValue
    @JsonValue
    private final String code;
    private final String desc;
}
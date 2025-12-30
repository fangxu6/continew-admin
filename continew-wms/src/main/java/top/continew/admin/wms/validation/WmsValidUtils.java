package top.continew.admin.wms.validation;

import cn.hutool.core.util.StrUtil;
import top.continew.admin.common.util.ValidUtils;

/**
 * WMS模块验证工具类
 *
 * @author 小aron
 * @since 2025/12/30
 */
public class WmsValidUtils extends ValidUtils {

    /**
     * 验证物品编码是否唯一
     *
     * @param code 物品编码
     * @return boolean
     */
    public static boolean isItemCodeUnique(String code) {
        if (StrUtil.isBlank(code)) {
            return false;
        }
        // 实现具体的验证逻辑
        return true;
    }

    /**
     * 验证位置编码是否唯一
     *
     * @param code 位置编码
     * @return boolean
     */
    public static boolean isLocationCodeUnique(String code) {
        if (StrUtil.isBlank(code)) {
            return false;
        }
        // 实现具体的验证逻辑
        return true;
    }

    /**
     * 验证供应商编码是否唯一
     *
     * @param code 供应商编码
     * @return boolean
     */
    public static boolean isSupplierCodeUnique(String code) {
        if (StrUtil.isBlank(code)) {
            return false;
        }
        // 实现具体的验证逻辑
        return true;
    }

    /**
     * 验证客户编码是否唯一
     *
     * @param code 客户编码
     * @return boolean
     */
    public static boolean isCustomerCodeUnique(String code) {
        if (StrUtil.isBlank(code)) {
            return false;
        }
        // 实现具体的验证逻辑
        return true;
    }
}
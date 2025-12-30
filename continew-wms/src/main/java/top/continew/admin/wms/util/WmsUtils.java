package top.continew.admin.wms.util;

import cn.hutool.core.util.StrUtil;

/**
 * WMS模块工具类
 *
 * @author 小aron
 * @since 2025/12/30
 */
public class WmsUtils {

    /**
     * 生成物品编码
     *
     * @param prefix 前缀
     * @param id ID
     * @return String
     */
    public static String generateItemCode(String prefix, Long id) {
        if (StrUtil.isBlank(prefix)) {
            prefix = "ITEM";
        }
        return prefix + System.currentTimeMillis() + id;
    }

    /**
     * 生成位置编码
     *
     * @param warehouseCode 仓库编码
     * @param area 区域
     * @param row 排
     * @param column 列
     * @param level 层
     * @param position 位
     * @return String
     */
    public static String generateLocationCode(String warehouseCode, String area, String row, String column, String level, String position) {
        StringBuilder sb = new StringBuilder();
        if (StrUtil.isNotBlank(warehouseCode)) {
            sb.append(warehouseCode).append("-");
        }
        if (StrUtil.isNotBlank(area)) {
            sb.append(area).append("-");
        }
        if (StrUtil.isNotBlank(row)) {
            sb.append(row).append("-");
        }
        if (StrUtil.isNotBlank(column)) {
            sb.append(column).append("-");
        }
        if (StrUtil.isNotBlank(level)) {
            sb.append(level).append("-");
        }
        if (StrUtil.isNotBlank(position)) {
            sb.append(position);
        }
        return sb.toString();
    }

    /**
     * 生成供应商编码
     *
     * @param prefix 前缀
     * @param id ID
     * @return String
     */
    public static String generateSupplierCode(String prefix, Long id) {
        if (StrUtil.isBlank(prefix)) {
            prefix = "SUP";
        }
        return prefix + System.currentTimeMillis() + id;
    }

    /**
     * 生成客户编码
     *
     * @param prefix 前缀
     * @param id ID
     * @return String
     */
    public static String generateCustomerCode(String prefix, Long id) {
        if (StrUtil.isBlank(prefix)) {
            prefix = "CUST";
        }
        return prefix + System.currentTimeMillis() + id;
    }
}
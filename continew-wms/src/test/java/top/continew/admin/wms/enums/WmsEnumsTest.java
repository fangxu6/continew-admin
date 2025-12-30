package top.continew.admin.wms.enums;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS枚举类测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsEnumsTest {

    @Test
    void testItemStatusEnumNotNull() {
        assertNotNull(ItemStatusEnum.class, "ItemStatusEnum class should not be null");
    }

    @Test
    void testLocationStatusEnumNotNull() {
        assertNotNull(LocationStatusEnum.class, "LocationStatusEnum class should not be null");
    }

    @Test
    void testSupplierStatusEnumNotNull() {
        assertNotNull(SupplierStatusEnum.class, "SupplierStatusEnum class should not be null");
    }

    @Test
    void testCustomerStatusEnumNotNull() {
        assertNotNull(CustomerStatusEnum.class, "CustomerStatusEnum class should not be null");
    }

    @Test
    void testWarehouseStatusEnumNotNull() {
        assertNotNull(WarehouseStatusEnum.class, "WarehouseStatusEnum class should not be null");
    }
}
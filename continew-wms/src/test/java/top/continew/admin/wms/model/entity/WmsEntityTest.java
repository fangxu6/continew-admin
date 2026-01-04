package top.continew.admin.wms.model.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS实体类测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsEntityTest {

    @Test
    void testItemEntityNotNull() {
        assertNotNull(ItemDO.class, "Item entity should not be null");
    }

    @Test
    void testLocationEntityNotNull() {
        assertNotNull(LocationDO.class, "Location entity should not be null");
    }

    @Test
    void testSupplierEntityNotNull() {
        assertNotNull(SupplierDO.class, "Supplier entity should not be null");
    }

    @Test
    void testCustomerEntityNotNull() {
        assertNotNull(CustomerDO.class, "Customer entity should not be null");
    }

    @Test
    void testWarehouseEntityNotNull() {
        assertNotNull(WarehouseDO.class, "Warehouse entity should not be null");
    }
}
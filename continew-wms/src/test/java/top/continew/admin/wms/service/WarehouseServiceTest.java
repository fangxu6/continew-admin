package top.continew.admin.wms.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WarehouseService测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WarehouseServiceTest {

    private final WarehouseService warehouseService;

    public WarehouseServiceTest(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Test
    void testWarehouseServiceNotNull() {
        assertNotNull(warehouseService, "WarehouseService should not be null");
    }
}
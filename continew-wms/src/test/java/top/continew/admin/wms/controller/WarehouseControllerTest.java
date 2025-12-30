package top.continew.admin.wms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WarehouseController测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WarehouseControllerTest {

    private final WarehouseController warehouseController;

    public WarehouseControllerTest(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }

    @Test
    void testWarehouseControllerNotNull() {
        assertNotNull(warehouseController, "WarehouseController should not be null");
    }
}
package top.continew.admin.wms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * SupplierController测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class SupplierControllerTest {

    private final SupplierController supplierController;

    public SupplierControllerTest(SupplierController supplierController) {
        this.supplierController = supplierController;
    }

    @Test
    void testSupplierControllerNotNull() {
        assertNotNull(supplierController, "SupplierController should not be null");
    }
}
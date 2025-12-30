package top.continew.admin.wms.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * SupplierService测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class SupplierServiceTest {

    private final SupplierService supplierService;

    public SupplierServiceTest(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Test
    void testSupplierServiceNotNull() {
        assertNotNull(supplierService, "SupplierService should not be null");
    }
}
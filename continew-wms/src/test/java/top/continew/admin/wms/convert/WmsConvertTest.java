package top.continew.admin.wms.convert;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS转换器测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsConvertTest {

    @Test
    void testItemConvertNotNull() {
        assertNotNull(ItemConvert.INSTANCE, "ItemConvert should not be null");
    }

    @Test
    void testLocationConvertNotNull() {
        assertNotNull(LocationConvert.INSTANCE, "LocationConvert should not be null");
    }

    @Test
    void testSupplierConvertNotNull() {
        assertNotNull(SupplierConvert.INSTANCE, "SupplierConvert should not be null");
    }

    @Test
    void testCustomerConvertNotNull() {
        assertNotNull(CustomerConvert.INSTANCE, "CustomerConvert should not be null");
    }

    @Test
    void testWarehouseConvertNotNull() {
        assertNotNull(WarehouseConvert.INSTANCE, "WarehouseConvert should not be null");
    }
}
package top.continew.admin.wms.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS映射器测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsMapperTest {

    private final ItemMapper itemMapper;
    private final LocationMapper locationMapper;
    private final SupplierMapper supplierMapper;
    private final CustomerMapper customerMapper;
    private final WarehouseMapper warehouseMapper;

    public WmsMapperTest(ItemMapper itemMapper, LocationMapper locationMapper, SupplierMapper supplierMapper, 
                         CustomerMapper customerMapper, WarehouseMapper warehouseMapper) {
        this.itemMapper = itemMapper;
        this.locationMapper = locationMapper;
        this.supplierMapper = supplierMapper;
        this.customerMapper = customerMapper;
        this.warehouseMapper = warehouseMapper;
    }

    @Test
    void testItemMapperNotNull() {
        assertNotNull(itemMapper, "ItemMapper should not be null");
    }

    @Test
    void testLocationMapperNotNull() {
        assertNotNull(locationMapper, "LocationMapper should not be null");
    }

    @Test
    void testSupplierMapperNotNull() {
        assertNotNull(supplierMapper, "SupplierMapper should not be null");
    }

    @Test
    void testCustomerMapperNotNull() {
        assertNotNull(customerMapper, "CustomerMapper should not be null");
    }

    @Test
    void testWarehouseMapperNotNull() {
        assertNotNull(warehouseMapper, "WarehouseMapper should not be null");
    }
}
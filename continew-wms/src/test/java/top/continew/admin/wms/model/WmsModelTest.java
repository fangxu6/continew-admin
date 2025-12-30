package top.continew.admin.wms.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS模型DTO测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsModelTest {

    @Test
    void testItemReqNotNull() {
        assertNotNull(top.continew.admin.wms.model.req.ItemReq.class, "ItemReq should not be null");
    }

    @Test
    void testLocationReqNotNull() {
        assertNotNull(top.continew.admin.wms.model.req.LocationReq.class, "LocationReq should not be null");
    }

    @Test
    void testSupplierReqNotNull() {
        assertNotNull(top.continew.admin.wms.model.req.SupplierReq.class, "SupplierReq should not be null");
    }

    @Test
    void testCustomerReqNotNull() {
        assertNotNull(top.continew.admin.wms.model.req.CustomerReq.class, "CustomerReq should not be null");
    }

    @Test
    void testItemRespNotNull() {
        assertNotNull(top.continew.admin.wms.model.resp.ItemResp.class, "ItemResp should not be null");
    }

    @Test
    void testLocationRespNotNull() {
        assertNotNull(top.continew.admin.wms.model.resp.LocationResp.class, "LocationResp should not be null");
    }

    @Test
    void testSupplierRespNotNull() {
        assertNotNull(top.continew.admin.wms.model.resp.SupplierResp.class, "SupplierResp should not be null");
    }

    @Test
    void testCustomerRespNotNull() {
        assertNotNull(top.continew.admin.wms.model.resp.CustomerResp.class, "CustomerResp should not be null");
    }

    @Test
    void testItemQueryNotNull() {
        assertNotNull(top.continew.admin.wms.model.query.ItemQuery.class, "ItemQuery should not be null");
    }

    @Test
    void testLocationQueryNotNull() {
        assertNotNull(top.continew.admin.wms.model.query.LocationQuery.class, "LocationQuery should not be null");
    }

    @Test
    void testSupplierQueryNotNull() {
        assertNotNull(top.continew.admin.wms.model.query.SupplierQuery.class, "SupplierQuery should not be null");
    }

    @Test
    void testCustomerQueryNotNull() {
        assertNotNull(top.continew.admin.wms.model.query.CustomerQuery.class, "CustomerQuery should not be null");
    }
}
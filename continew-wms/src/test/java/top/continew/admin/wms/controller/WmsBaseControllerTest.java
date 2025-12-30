package top.continew.admin.wms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS基础控制器测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsBaseControllerTest {

    private final WmsBaseController<?, ?, ?, ?, ?> wmsBaseController;

    public WmsBaseControllerTest(WmsBaseController<?, ?, ?, ?, ?> wmsBaseController) {
        this.wmsBaseController = wmsBaseController;
    }

    @Test
    void testWmsBaseControllerNotNull() {
        assertNotNull(wmsBaseController, "WmsBaseController should not be null");
    }
}
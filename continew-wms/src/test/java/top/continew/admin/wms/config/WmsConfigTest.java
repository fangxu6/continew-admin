package top.continew.admin.wms.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS配置测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsConfigTest {

    private final WmsConfig wmsConfig;

    public WmsConfigTest(WmsConfig wmsConfig) {
        this.wmsConfig = wmsConfig;
    }

    @Test
    void testWmsConfigNotNull() {
        assertNotNull(wmsConfig, "WmsConfig should not be null");
    }
}
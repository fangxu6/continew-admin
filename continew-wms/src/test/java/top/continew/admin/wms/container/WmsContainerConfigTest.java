package top.continew.admin.wms.container;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS容器配置测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsContainerConfigTest {

    private final WmsContainerConfig wmsContainerConfig;

    public WmsContainerConfigTest(WmsContainerConfig wmsContainerConfig) {
        this.wmsContainerConfig = wmsContainerConfig;
    }

    @Test
    void testWmsContainerConfigNotNull() {
        assertNotNull(wmsContainerConfig, "WmsContainerConfig should not be null");
    }
}
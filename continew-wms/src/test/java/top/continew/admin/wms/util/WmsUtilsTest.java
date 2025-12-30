package top.continew.admin.wms.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS工具类测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsUtilsTest {

    @Test
    void testWmsUtilsNotNull() {
        assertNotNull(WmsUtils.class, "WmsUtils class should not be null");
    }
}
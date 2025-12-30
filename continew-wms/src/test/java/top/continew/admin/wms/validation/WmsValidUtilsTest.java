package top.continew.admin.wms.validation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS验证工具类测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsValidUtilsTest {

    @Test
    void testWmsValidUtilsNotNull() {
        assertNotNull(WmsValidUtils.class, "WmsValidUtils class should not be null");
    }
}
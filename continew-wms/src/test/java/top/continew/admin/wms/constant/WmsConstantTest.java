package top.continew.admin.wms.constant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS常量类测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsConstantTest {

    @Test
    void testWmsConstantNotNull() {
        assertNotNull(WmsConstant.class, "WmsConstant class should not be null");
    }
}
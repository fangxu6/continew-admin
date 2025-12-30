package top.continew.admin.wms.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS异常处理器测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class WmsExceptionHandlerTest {

    private final WmsExceptionHandler wmsExceptionHandler;

    public WmsExceptionHandlerTest(WmsExceptionHandler wmsExceptionHandler) {
        this.wmsExceptionHandler = wmsExceptionHandler;
    }

    @Test
    void testWmsExceptionHandlerNotNull() {
        assertNotNull(wmsExceptionHandler, "WmsExceptionHandler should not be null");
    }
}
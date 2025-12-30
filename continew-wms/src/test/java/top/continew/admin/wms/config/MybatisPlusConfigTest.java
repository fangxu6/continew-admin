package top.continew.admin.wms.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * WMS MyBatis Plus配置测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class MybatisPlusConfigTest {

    private final MybatisPlusConfig mybatisPlusConfig;

    public MybatisPlusConfigTest(MybatisPlusConfig mybatisPlusConfig) {
        this.mybatisPlusConfig = mybatisPlusConfig;
    }

    @Test
    void testMybatisPlusConfigNotNull() {
        assertNotNull(mybatisPlusConfig, "MybatisPlusConfig should not be null");
    }
}
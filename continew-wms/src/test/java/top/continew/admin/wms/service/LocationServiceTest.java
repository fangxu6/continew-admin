package top.continew.admin.wms.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * LocationService测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class LocationServiceTest {

    private final LocationService locationService;

    public LocationServiceTest(LocationService locationService) {
        this.locationService = locationService;
    }

    @Test
    void testLocationServiceNotNull() {
        assertNotNull(locationService, "LocationService should not be null");
    }
}
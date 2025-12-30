package top.continew.admin.wms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * LocationController测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class LocationControllerTest {

    private final LocationController locationController;

    public LocationControllerTest(LocationController locationController) {
        this.locationController = locationController;
    }

    @Test
    void testLocationControllerNotNull() {
        assertNotNull(locationController, "LocationController should not be null");
    }
}
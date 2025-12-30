package top.continew.admin.wms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * ItemController测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class ItemControllerTest {

    private final ItemController itemController;

    public ItemControllerTest(ItemController itemController) {
        this.itemController = itemController;
    }

    @Test
    void testItemControllerNotNull() {
        assertNotNull(itemController, "ItemController should not be null");
    }
}
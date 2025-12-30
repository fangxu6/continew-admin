package top.continew.admin.wms.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * ItemService测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class ItemServiceTest {

    private final ItemService itemService;

    public ItemServiceTest(ItemService itemService) {
        this.itemService = itemService;
    }

    @Test
    void testItemServiceNotNull() {
        assertNotNull(itemService, "ItemService should not be null");
    }
}
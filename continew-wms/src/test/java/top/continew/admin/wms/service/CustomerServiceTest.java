package top.continew.admin.wms.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * CustomerService测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    void testCustomerServiceNotNull() {
        assertNotNull(customerService, "CustomerService should not be null");
    }
}
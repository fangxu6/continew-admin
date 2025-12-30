package top.continew.admin.wms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * CustomerController测试类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@SpringBootTest
public class CustomerControllerTest {

    private final CustomerController customerController;

    public CustomerControllerTest(CustomerController customerController) {
        this.customerController = customerController;
    }

    @Test
    void testCustomerControllerNotNull() {
        assertNotNull(customerController, "CustomerController should not be null");
    }
}
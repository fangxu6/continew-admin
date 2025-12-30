package top.continew.admin.wms.container;

import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;
import cn.crane4j.core.support.AnnotationFinder;
import cn.crane4j.core.support.container.MethodContainerFactory;
import cn.crane4j.core.support.converter.TypeConverter;
import cn.crane4j.core.support.proxy.ProxyContainerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import top.continew.admin.wms.service.ItemService;
import top.continew.admin.wms.service.LocationService;
import top.continew.admin.wms.service.SupplierService;
import top.continew.admin.wms.service.CustomerService;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * WMS模块Crane4j数据填充容器配置
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Component
@RequiredArgsConstructor
public class WmsContainerConfig {

    private final ItemService itemService;
    private final LocationService locationService;
    private final SupplierService supplierService;
    private final CustomerService customerService;

    /**
     * 物品数据容器
     *
     * @return Container<String, Object>
     */
    @Bean
    public Container<Long, Object> itemContainer() {
        return Containers.forLambda("item", Long.class, ids -> itemService.listByIds(ids));
    }

    /**
     * 位置数据容器
     *
     * @return Container<String, Object>
     */
    @Bean
    public Container<Long, Object> locationContainer() {
        return Containers.forLambda("location", Long.class, ids -> locationService.listByIds(ids));
    }

    /**
     * 供应商数据容器
     *
     * @return Container<String, Object>
     */
    @Bean
    public Container<Long, Object> supplierContainer() {
        return Containers.forLambda("supplier", Long.class, ids -> supplierService.listByIds(ids));
    }

    /**
     * 客户数据容器
     *
     * @return Container<String, Object>
     */
    @Bean
    public Container<Long, Object> customerContainer() {
        return Containers.forLambda("customer", Long.class, ids -> customerService.listByIds(ids));
    }
}
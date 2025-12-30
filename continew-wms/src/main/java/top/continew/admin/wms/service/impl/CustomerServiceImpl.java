package top.continew.admin.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.StrUtil;
import top.continew.admin.wms.convert.CustomerConvert;
import top.continew.admin.wms.mapper.CustomerMapper;
import top.continew.admin.wms.model.entity.Customer;
import top.continew.admin.wms.model.req.CustomerReq;
import top.continew.admin.wms.model.resp.CustomerResp;
import top.continew.admin.wms.model.query.CustomerQuery;
import top.continew.admin.wms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 客户服务实现类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public CustomerResp get(Long id) {
        Customer entity = this.getById(id);
        return CustomerConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public CustomerResp create(CustomerReq req) {
        Customer entity = CustomerConvert.INSTANCE.req2Entity(req);
        this.save(entity);
        return CustomerConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public CustomerResp update(CustomerReq req) {
        Customer entity = CustomerConvert.INSTANCE.req2Entity(req);
        this.updateById(entity);
        return CustomerConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }

    @Override
    public LambdaQueryWrapper<Customer> getWrapper(CustomerQuery query) {
        return Wrappers.<Customer>lambdaQuery()
            .like(StrUtil.isNotBlank(query.getCode()), Customer::getCode, query.getCode())
            .like(StrUtil.isNotBlank(query.getName()), Customer::getName, query.getName())
            .eq(StrUtil.isNotBlank(query.getStatus()), Customer::getStatus, query.getStatus());
    }
}
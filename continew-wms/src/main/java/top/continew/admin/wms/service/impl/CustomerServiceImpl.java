package top.continew.admin.wms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.wms.mapper.CustomerMapper;
import top.continew.admin.wms.model.entity.CustomerDO;
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
public class CustomerServiceImpl extends BaseServiceImpl<CustomerMapper, CustomerDO, CustomerResp, CustomerResp, CustomerQuery, CustomerReq> implements CustomerService {

    @Override
    public LambdaQueryWrapper<CustomerDO> getWrapper(CustomerQuery query) {
        return Wrappers.<CustomerDO>lambdaQuery()
            .like(query.getCode() != null, CustomerDO::getCode, query.getCode())
            .like(query.getName() != null, CustomerDO::getName, query.getName())
            .eq(query.getStatus() != null, CustomerDO::getStatus, query.getStatus());
    }
}
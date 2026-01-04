package top.continew.admin.wms.service.impl;

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
import top.continew.starter.data.mapper.BaseMapper;

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
}
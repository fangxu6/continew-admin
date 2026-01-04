package top.continew.admin.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.wms.mapper.SupplierMapper;
import top.continew.admin.wms.model.entity.SupplierDO;
import top.continew.admin.wms.model.req.SupplierReq;
import top.continew.admin.wms.model.resp.SupplierResp;
import top.continew.admin.wms.model.query.SupplierQuery;
import top.continew.admin.wms.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 供应商服务实现类
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SupplierServiceImpl extends BaseServiceImpl<SupplierMapper, SupplierDO, SupplierResp, SupplierResp, SupplierQuery, SupplierReq> implements SupplierService {

    @Override
    public LambdaQueryWrapper<SupplierDO> getWrapper(SupplierQuery query) {
        return Wrappers.<SupplierDO>lambdaQuery()
            .like(query.getCode() != null, SupplierDO::getCode, query.getCode())
            .like(query.getName() != null, SupplierDO::getName, query.getName())
            .eq(query.getStatus() != null, SupplierDO::getStatus, query.getStatus());
    }
}
package top.continew.admin.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.StrUtil;
import top.continew.admin.wms.convert.SupplierConvert;
import top.continew.admin.wms.mapper.SupplierMapper;
import top.continew.admin.wms.model.entity.Supplier;
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
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {

    @Override
    public SupplierResp get(Long id) {
        Supplier entity = this.getById(id);
        return SupplierConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public SupplierResp create(SupplierReq req) {
        Supplier entity = SupplierConvert.INSTANCE.req2Entity(req);
        this.save(entity);
        return SupplierConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public SupplierResp update(SupplierReq req) {
        Supplier entity = SupplierConvert.INSTANCE.req2Entity(req);
        this.updateById(entity);
        return SupplierConvert.INSTANCE.entity2Resp(entity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }

    @Override
    public LambdaQueryWrapper<Supplier> getWrapper(SupplierQuery query) {
        return Wrappers.<Supplier>lambdaQuery()
            .like(StrUtil.isNotBlank(query.getCode()), Supplier::getCode, query.getCode())
            .like(StrUtil.isNotBlank(query.getName()), Supplier::getName, query.getName())
            .eq(StrUtil.isNotBlank(query.getStatus()), Supplier::getStatus, query.getStatus());
    }
}
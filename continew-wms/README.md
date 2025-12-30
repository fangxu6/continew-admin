# WMS模块 (Warehouse Management System)

## 概述

WMS模块是仓库管理系统的核心组件，提供完整的仓库管理功能，包括基础数据管理、入库作业、出库作业、库存管理、库内作业、终端交互、接口集成和报表分析等功能。

## 功能特性

### 1. 基础数据管理
- 物品管理：物品的创建、更新、查询和删除
- 位置管理：仓库位置的配置和管理
- 供应商管理：供应商信息的维护
- 客户管理：客户信息的维护
- 仓库管理：仓库信息的配置

### 2. 作业管理
- 入库作业：处理货物入库流程
- 出库作业：处理货物出库流程
- 库内作业：库存转移、盘点等内部操作

### 3. 库存管理
- 实时库存跟踪
- 库存调整和盘点
- 库存预警和报警

### 4. 报表分析
- 库存报表
- 作业效率报表
- 库存周转率报表

## 技术架构

本模块采用COLA架构模式：
- **Controller层**: 处理HTTP请求，参数校验
- **Service层**: 业务逻辑处理，事务管理
- **Mapper层**: 数据访问，SQL映射
- **Model层**: 数据模型，DTO对象

## 依赖

- Spring Boot 3.3.12
- MyBatis Plus
- Sa-Token (认证授权)
- Redisson (缓存)
- FastExcel (报表导出)
- Crane4j (数据填充)
- SpringDoc (API文档)

## 使用说明

### 启动配置

在application.yml中配置WMS模块相关参数：

```yaml
continew:
  wms:
    # 库存预警阈值
    inventory:
      warning-threshold: 10
      # 是否启用负库存
      allow-negative: false
    # 作业配置
    operation:
      # 是否启用作业流程审批
      require-approval: false
      # 作业超时时间（分钟）
      timeout: 1440
```

### API接口

基础数据管理接口：
- `POST /wms/item` - 创建物品
- `PUT /wms/item/{id}` - 更新物品
- `GET /wms/item/{id}` - 查询物品详情
- `GET /wms/item/page` - 分页查询物品

更多接口请参考API文档。

## 开发指南

### 代码规范
- 遵循阿里巴巴Java编码规范
- 使用Lombok简化代码
- 统一异常处理
- 统一日志记录

### 最佳实践
- 使用常量类管理常量
- 使用枚举类管理状态
- 使用验证注解进行参数校验
- 使用缓存优化查询性能
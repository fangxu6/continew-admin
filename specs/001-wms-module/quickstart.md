# WMS模块快速入门指南

**功能**: WMS模块实现
**分支**: 001-wms-module
**日期**: 2025-12-30

## 概述

本指南介绍如何快速启动和使用WMS（仓库管理系统）模块。该模块遵循COLA架构模式，与ContiNew Admin系统集成，提供完整的仓库管理功能。

## 环境要求

### 开发环境
- Java 17 或更高版本
- Maven 3.8.0 或更高版本
- MySQL 8.0.42
- Redis 7.2.8 或更高版本

### 运行时依赖
- Spring Boot 3.3.12
- MyBatis Plus 3.5.12
- Sa-Token 1.44.0
- Redisson 3.49.0

## 项目结构

```
continew-wms/                    # WMS模块根目录
├── src/
│   ├── main/
│   │   ├── java/top/continew/admin/wms/
│   │   │   ├── api/             # 公共业务API实现
│   │   │   ├── controller/      # WMS相关API控制器
│   │   │   ├── service/         # WMS相关业务接口及实现类
│   │   │   ├── mapper/          # WMS相关数据访问层
│   │   │   ├── model/           # WMS相关数据模型
│   │   │   │   ├── entity/      # 实体类
│   │   │   │   ├── query/       # 查询条件
│   │   │   │   ├── req/         # 请求参数
│   │   │   │   └── resp/        # 响应参数
│   │   │   ├── enums/           # 枚举类
│   │   │   ├── constant/        # 常量类
│   │   │   ├── util/            # 工具类
│   │   │   ├── validation/      # 参数校验工具类
│   │   │   ├── container/       # Crane4j数据填充容器配置
│   │   │   └── config/          # 配置类
│   │   └── resources/
│   │       └── mapper/          # MyBatis映射文件
│   └── test/                    # 测试代码
└── pom.xml                      # Maven配置文件
```

## 快速开始

### 1. 添加模块依赖

在项目的主POM文件中添加WMS模块依赖：

```xml
<dependency>
    <groupId>top.continew</groupId>
    <artifactId>continew-wms</artifactId>
    <version>${project.version}</version>
</dependency>
```

### 2. 配置数据库

在 `application.yml` 中配置WMS模块的数据库连接：

```yaml
spring:
  datasource:
    dynamic:
      datasource:
        wms:
          url: jdbc:mysql://localhost:3306/continew_wms?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true
          username: root
          password: password
          driver-class-name: com.mysql.cj.jdbc.Driver
```

### 3. 初始化数据库表

运行数据库初始化脚本创建WMS模块所需的表结构。脚本位置：
- `src/main/resources/db/changelog/mysql/wms/`

### 4. 启用WMS模块

在启动类中添加WMS模块的包扫描：

```java
@SpringBootApplication
@MapperScan(basePackages = {"top.continew.admin.**.mapper", "top.continew.admin.wms.mapper"})
@ComponentScan(basePackages = {"top.continew.admin", "top.continew.admin.wms"})
public class ContiNewAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContiNewAdminApplication.class, args);
    }
}
```

## 核心功能使用

### 1. 基础数据管理

#### 物品管理
- 创建物品：`POST /wms/item`
- 更新物品：`PUT /wms/item/{id}`
- 查询物品：`GET /wms/item/{id}`
- 删除物品：`DELETE /wms/item/{id}`
- 分页查询：`GET /wms/item/page`

#### 位置管理
- 创建位置：`POST /wms/location`
- 更新位置：`PUT /wms/location/{id}`
- 查询位置：`GET /wms/location/{id}`
- 分页查询：`GET /wms/location/page`

### 2. 入库作业

#### 创建入库订单
```json
{
  "orderNo": "R20251230001",
  "supplierId": 1,
  "type": "PURCHASE",
  "remark": "采购入库",
  "items": [
    {
      "itemId": 1,
      "quantity": 100,
      "unitPrice": 10.00
    }
  ]
}
```

### 3. 出库作业

#### 创建出库订单
```json
{
  "orderNo": "D20251230001",
  "customerId": 1,
  "type": "SALE",
  "remark": "销售出库",
  "items": [
    {
      "itemId": 1,
      "quantity": 50
    }
  ]
}
```

### 4. 库存管理

#### 查询库存
- 按物品查询：`GET /wms/inventory/by-item/{itemId}`
- 按位置查询：`GET /wms/inventory/by-location/{locationId}`
- 库存盘点：`POST /wms/inventory/check`

## API接口

### 基础数据接口
- `GET /wms/item/dict` - 获取物品字典
- `GET /wms/location/tree` - 获取位置树形结构
- `GET /wms/supplier/dict` - 获取供应商字典
- `GET /wms/customer/dict` - 获取客户字典

### 作业接口
- `POST /wms/receipt` - 创建入库订单
- `POST /wms/dispatch` - 创建出库订单
- `POST /wms/movement` - 创建移动记录
- `GET /wms/order/progress/{orderNo}` - 查询订单进度

### 报表接口
- `GET /wms/report/inventory` - 库存报表
- `GET /wms/report/turnover` - 库存周转报表
- `GET /wms/report/operation` - 作业效率报表

## 配置选项

### WMS模块配置
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

## 测试

### 单元测试
```bash
mvn test -Dtest="Wms*Test"
```

### 集成测试
```bash
mvn test -Dtest="*IntegrationTest"
```

## 部署

### 1. 打包
```bash
mvn clean package -DskipTests
```

### 2. 运行
```bash
java -jar continew-wms-${version}.jar
```

## 开发指南

### 遵循COLA架构
- **Controller层**: 处理HTTP请求，参数校验
- **Service层**: 业务逻辑处理，事务管理
- **Mapper层**: 数据访问，SQL映射
- **Model层**: 数据模型，DTO对象

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
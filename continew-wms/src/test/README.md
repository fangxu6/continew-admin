# WMS模块测试说明

## 测试结构

WMS模块的测试结构遵循以下目录结构：

```
src/test/java/top/continew/admin/wms/
├── WmsModuleTest.java                 # 模块基础测试
├── WmsModuleOverallTest.java          # 模块整体测试
├── config/                            # 配置相关测试
│   ├── WmsConfigTest.java
│   ├── WmsExceptionHandlerTest.java
│   └── MybatisPlusConfigTest.java
├── controller/                        # 控制器相关测试
│   ├── ItemControllerTest.java
│   ├── LocationControllerTest.java
│   ├── SupplierControllerTest.java
│   ├── CustomerControllerTest.java
│   ├── WarehouseControllerTest.java
│   └── WmsBaseControllerTest.java
├── service/                           # 服务相关测试
│   ├── ItemServiceTest.java
│   ├── LocationServiceTest.java
│   ├── SupplierServiceTest.java
│   ├── CustomerServiceTest.java
│   └── WarehouseServiceTest.java
├── mapper/                            # 映射器相关测试
│   └── WmsMapperTest.java
├── model/                             # 模型相关测试
│   └── WmsModelTest.java
├── model/entity/                      # 实体相关测试
│   └── WmsEntityTest.java
├── convert/                           # 转换器相关测试
│   └── WmsConvertTest.java
├── enums/                             # 枚举相关测试
│   └── WmsEnumsTest.java
├── constant/                          # 常量相关测试
│   └── WmsConstantTest.java
├── util/                              # 工具类相关测试
│   └── WmsUtilsTest.java
├── validation/                        # 验证相关测试
│   └── WmsValidUtilsTest.java
└── container/                         # 容器配置相关测试
    └── WmsContainerConfigTest.java
```

## 测试说明

### 1. 模块测试
- `WmsModuleTest.java`: 基础的Spring Boot应用上下文加载测试
- `WmsModuleOverallTest.java`: 模块整体功能测试

### 2. 配置测试
- `WmsConfigTest.java`: WMS模块配置类测试
- `WmsExceptionHandlerTest.java`: 异常处理器测试
- `MybatisPlusConfigTest.java`: MyBatis Plus配置测试

### 3. 控制器测试
- 各个控制器的依赖注入测试，确保Spring上下文正确加载

### 4. 服务测试
- 各个服务类的依赖注入测试，确保服务层正常工作

### 5. 映射器测试
- 各个Mapper的依赖注入测试，确保数据访问层正常工作

### 6. 模型测试
- DTO和实体类的存在性测试

### 7. 其他组件测试
- 转换器、枚举、常量、工具类、验证工具、容器配置等的测试

## 运行测试

### 运行所有测试
```bash
mvn test
```

### 运行特定测试
```bash
mvn test -Dtest=WmsModuleTest
```

### 运行特定包下的测试
```bash
mvn test -Dtest="top.continew.admin.wms.service.*"
```

## 测试覆盖率

WMS模块的测试覆盖率目标为80%以上，确保核心业务逻辑得到充分测试。

## 测试原则

1. **独立性**: 每个测试应该独立运行，不依赖其他测试的结果
2. **可重复性**: 测试应该能够在任何环境下重复运行并得到相同结果
3. **快速性**: 测试应该快速执行，以便频繁运行
4. **可读性**: 测试代码应该清晰易懂，便于维护
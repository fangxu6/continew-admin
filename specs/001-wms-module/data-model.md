# WMS模块数据模型

**功能**: WMS模块实现
**分支**: 001-wms-module
**日期**: 2025-12-30

## 实体模型

### 1. 物品 (Item)
**描述**: 仓库中存储的产品或材料
**字段**:
- id: Long (主键)
- code: String (物品编码，唯一，必填)
- name: String (物品名称，必填)
- description: String (物品描述)
- category: String (物品类别)
- unit: String (计量单位)
- length: BigDecimal (长度)
- width: BigDecimal (宽度)
- height: BigDecimal (高度)
- weight: BigDecimal (重量)
- status: ItemStatus (物品状态: 启用/禁用)
- createTime: LocalDateTime (创建时间)
- updateTime: LocalDateTime (更新时间)
- createBy: Long (创建人)
- updateBy: Long (更新人)

**验证规则**:
- 物品编码必须唯一
- 物品名称不能为空
- 计量单位必须在预定义范围内

**状态转换**:
- 启用 → 禁用 (管理员操作)
- 禁用 → 启用 (管理员操作)

### 2. 位置 (Location)
**描述**: 仓库中的物理存储区域
**字段**:
- id: Long (主键)
- code: String (位置编码，唯一，必填)
- name: String (位置名称，必填)
- warehouseId: Long (所属仓库ID，必填)
- area: String (所属区域)
- row: String (排)
- column: String (列)
- level: String (层)
- position: String (位)
- type: LocationType (位置类型: 存储/拣选/暂存等)
- capacity: BigDecimal (容量)
- usedCapacity: BigDecimal (已用容量)
- status: LocationStatus (位置状态: 可用/不可用/锁定)
- remark: String (备注)
- createTime: LocalDateTime (创建时间)
- updateTime: LocalDateTime (更新时间)
- createBy: Long (创建人)
- updateBy: Long (更新人)

**验证规则**:
- 位置编码在仓库内必须唯一
- 位置类型必须在预定义范围内
- 已用容量不能超过总容量

### 3. 库存 (Inventory)
**描述**: 特定位置的物品数量
**字段**:
- id: Long (主键)
- itemId: Long (物品ID，必填)
- locationId: Long (位置ID，必填)
- quantity: BigDecimal (总数量，必填)
- availableQuantity: BigDecimal (可用数量，必填)
- reservedQuantity: BigDecimal (预留数量)
- frozenQuantity: BigDecimal (冻结数量)
- batchNumber: String (批次号)
- productionDate: LocalDate (生产日期)
- expiryDate: LocalDate (过期日期)
- status: InventoryStatus (库存状态: 正常/冻结/预警)
- remark: String (备注)
- createTime: LocalDateTime (创建时间)
- updateTime: LocalDateTime (更新时间)
- createBy: Long (创建人)
- updateBy: Long (更新人)

**验证规则**:
- 物品ID和位置ID组合必须唯一
- 总数量 = 可用数量 + 预留数量 + 冻结数量
- 过期日期必须晚于生产日期

### 4. 入库订单 (ReceiptOrder)
**描述**: 来货交易记录
**字段**:
- id: Long (主键)
- orderNo: String (订单号，唯一，必填)
- supplierId: Long (供应商ID，必填)
- type: ReceiptOrderType (入库类型: 采购入库/退货入库等)
- status: ReceiptOrderStatus (订单状态: 待处理/处理中/已完成/已取消)
- totalAmount: BigDecimal (总金额)
- receivedAmount: BigDecimal (已收金额)
- remark: String (备注)
- expectReceiveTime: LocalDateTime (预计收货时间)
- actualReceiveTime: LocalDateTime (实际收货时间)
- handler: String (处理人)
- handlerId: Long (处理人ID)
- createTime: LocalDateTime (创建时间)
- updateTime: LocalDateTime (更新时间)
- createBy: Long (创建人)
- updateBy: Long (更新人)

**验证规则**:
- 订单号必须唯一
- 订单状态转换必须符合业务流程
- 已收金额不能超过总金额

**状态转换**:
- 待处理 → 处理中 (开始收货)
- 处理中 → 已完成 (收货完成)
- 待处理 → 已取消 (订单取消)

### 5. 出库订单 (DispatchOrder)
**描述**: 出货交易记录
**字段**:
- id: Long (主键)
- orderNo: String (订单号，唯一，必填)
- customerId: Long (客户ID，必填)
- type: DispatchOrderType (出库类型: 销售出库/调拨出库等)
- status: DispatchOrderStatus (订单状态: 待处理/已分配/拣选中/已完成/已取消)
- totalAmount: BigDecimal (总金额)
- dispatchedAmount: BigDecimal (已出库金额)
- remark: String (备注)
- expectDispatchTime: LocalDateTime (预计出库时间)
- actualDispatchTime: LocalDateTime (实际出库时间)
- handler: String (处理人)
- handlerId: Long (处理人ID)
- createTime: LocalDateTime (创建时间)
- updateTime: LocalDateTime (更新时间)
- createBy: Long (创建人)
- updateBy: Long (更新人)

**验证规则**:
- 订单号必须唯一
- 订单状态转换必须符合业务流程
- 已出库金额不能超过总金额

**状态转换**:
- 待处理 → 已分配 (分配库存)
- 已分配 → 拣选中 (开始拣选)
- 拣选中 → 已完成 (出库完成)
- 待处理 → 已取消 (订单取消)

### 6. 移动记录 (Movement)
**描述**: 物品在位置之间的内部转移
**字段**:
- id: Long (主键)
- movementNo: String (移动单号，唯一，必填)
- type: MovementType (移动类型: 调拨/移库/盘点调整等)
- sourceLocationId: Long (源位置ID)
- targetLocationId: Long (目标位置ID)
- itemId: Long (物品ID，必填)
- quantity: BigDecimal (移动数量，必填)
- status: MovementStatus (移动状态: 待处理/处理中/已完成)
- reason: String (移动原因)
- handler: String (处理人)
- handlerId: Long (处理人ID)
- createTime: LocalDateTime (创建时间)
- updateTime: LocalDateTime (更新时间)
- createBy: Long (创建人)
- updateBy: Long (更新人)

**验证规则**:
- 移动单号必须唯一
- 源位置和目标位置不能相同
- 移动数量必须大于0

### 7. 供应商 (Supplier)
**描述**: 向仓库提供货物的实体
**字段**:
- id: Long (主键)
- code: String (供应商编码，唯一，必填)
- name: String (供应商名称，必填)
- contact: String (联系人)
- phone: String (联系电话)
- email: String (邮箱)
- address: String (地址)
- status: SupplierStatus (供应商状态: 合作中/已终止)
- creditLevel: String (信用等级)
- remark: String (备注)
- createTime: LocalDateTime (创建时间)
- updateTime: LocalDateTime (更新时间)
- createBy: Long (创建人)
- updateBy: Long (更新人)

**验证规则**:
- 供应商编码必须唯一
- 供应商名称不能为空

### 8. 客户 (Customer)
**描述**: 从仓库接收货物的实体
**字段**:
- id: Long (主键)
- code: String (客户编码，唯一，必填)
- name: String (客户名称，必填)
- contact: String (联系人)
- phone: String (联系电话)
- email: String (邮箱)
- address: String (地址)
- status: CustomerStatus (客户状态: 合作中/已终止)
- creditLevel: String (信用等级)
- remark: String (备注)
- createTime: LocalDateTime (创建时间)
- updateTime: LocalDateTime (更新时间)
- createBy: Long (创建人)
- updateBy: Long (更新人)

**验证规则**:
- 客户编码必须唯一
- 客户名称不能为空

### 9. 仓库 (Warehouse)
**描述**: 仓库实体
**字段**:
- id: Long (主键)
- code: String (仓库编码，唯一，必填)
- name: String (仓库名称，必填)
- address: String (仓库地址)
- manager: String (仓库管理员)
- managerId: Long (仓库管理员ID)
- status: WarehouseStatus (仓库状态: 启用/禁用)
- remark: String (备注)
- createTime: LocalDateTime (创建时间)
- updateTime: LocalDateTime (更新时间)
- createBy: Long (创建人)
- updateBy: Long (更新人)

**验证规则**:
- 仓库编码必须唯一
- 仓库名称不能为空

## 实体关系

### 1. 物品与库存
- 一对多关系：一个物品可以在多个位置有库存
- 物品(1) → 库存(N)

### 2. 位置与库存
- 一对多关系：一个位置可以存储多种物品
- 位置(1) → 库存(N)

### 3. 供应商与入库订单
- 一对多关系：一个供应商可以有多个入库订单
- 供应商(1) → 入库订单(N)

### 4. 客户与出库订单
- 一对多关系：一个客户可以有多个出库订单
- 客户(1) → 出库订单(N)

### 5. 物品与入库订单
- 多对多关系：通过订单明细关联
- 物品(M) ←→ 入库订单(N)

### 6. 物品与出库订单
- 多对多关系：通过订单明细关联
- 物品(M) ←→ 出库订单(N)

## 数据完整性约束

### 1. 业务规则约束
- 库存数量不能为负数
- 库存状态必须与数量一致（如冻结数量不能超过总数量）
- 订单状态转换必须符合业务流程

### 2. 参照完整性
- 所有外键引用必须指向有效的主键
- 删除主记录前必须处理相关子记录

### 3. 唯一性约束
- 各实体的关键业务字段必须唯一
- 防止重复数据录入
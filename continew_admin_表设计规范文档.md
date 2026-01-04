# continew_admin 数据库 sys_ 表设计文档模板

**生成时间**: [待生成]  
**数据库**: continew_admin  

---

## 目录

> 本文档将在运行分析工具后自动生成完整内容

---

## 表设计规范总结

### 通用字段规范

基于 continew_admin 数据库中 sys_ 表的分析，以下字段建议作为标准字段：

| 字段名 | 类型 | 说明 | 必选 |
|--------|------|------|------|
| `id` | BIGINT | 主键 ID，自增 | ✓ 必选 |
| `create_time` | DATETIME | 创建时间 | ✓ 推荐 |
| `update_time` | DATETIME | 更新时间 | ✓ 推荐 |
| `create_user` | BIGINT/VARCHAR | 创建人 ID 或用户名 | 推荐 |
| `update_user` | BIGINT/VARCHAR | 更新人 ID 或用户名 | 推荐 |
| `deleted` | TINYINT | 删除标记（0-未删除，1-已删除） | 推荐 |


### 命名规范

#### 表名规范
- ✅ 使用小写字母
- ✅ 使用下划线 `_` 分隔单词
- ✅ 使用统一的业务前缀（如 `sys_`、`user_`、`order_`、`product_` 等）
- ✅ 表名应见名知义，能够直观反映业务含义
- ❌ 避免使用中文、特殊字符
- ❌ 避免使用保留关键字

示例：
```
✓ sys_user          - 系统用户表
✓ sys_role          - 系统角色表
✓ sys_menu          - 系统菜单表
✓ order_info        - 订单信息表
✓ product_category  - 产品分类表
```

#### 字段名规范
- ✅ 使用小写字母
- ✅ 使用下划线 `_` 分隔单词
- ✅ 主键统一使用 `id`
- ✅ 外键使用 `{引用表名}_id` 格式（如 `user_id`、`role_id`）
- ✅ 布尔字段使用 `is_` 或 `has_` 前缀（如 `is_enabled`、`has_children`）
- ✅ 时间字段使用 `_time` 或 `_at` 或 `_date` 后缀（如 `create_time`、`expired_at`、`birth_date`）
- ❌ 避免使用中文、特殊字符
- ❌ 避免使用保留关键字

示例：
```
✓ id               - 主键
✓ user_id          - 用户 ID（外键）
✓ user_name        - 用户名
✓ is_enabled       - 是否启用
✓ has_children     - 是否有子节点
✓ create_time      - 创建时间
✓ expired_at       - 过期时间
✓ birth_date       - 出生日期
```

#### 索引名规范
- 主键索引：`PRIMARY` 或 `PK_{table_name}`
- 唯一索引：`UNI_{table_name}_{column_name}` 或 `UK_{column_name}`
- 普通索引：`IDX_{table_name}_{column_name}` 或 `IX_{column_name}`

### 数据类型规范

#### 整数类型
| 类型 | 范围 | 使用场景 |
|------|------|----------|
| `TINYINT` | -128 ~ 127 或 0 ~ 255 | 状态、标志位、年龄等小整数 |
| `SMALLINT` | -32768 ~ 32767 | 较小的数值 |
| `INT` | -2147483648 ~ 2147483647 | 一般整数、排序号 |
| `BIGINT` | 非常大的范围 | 主键 ID、大数值、雪花 ID |

#### 字符串类型
| 类型 | 长度 | 使用场景 |
|------|------|----------|
| `CHAR(n)` | 固定长度，n ≤ 255 | 固定长度字符串（如手机号、身份证号） |
| `VARCHAR(n)` | 可变长度，n ≤ 65535 | 变长字符串（姓名、地址、描述等） |
| `TEXT` | 最多 65535 字符 | 较长文本 |
| `MEDIUMTEXT` | 最多 16MB | 长文本 |
| `LONGTEXT` | 最多 4GB | 超长文本 |

常用长度建议：
- 用户名：`VARCHAR(50)`
- 姓名：`VARCHAR(50)`
- 手机号：`CHAR(11)` 或 `VARCHAR(20)`
- 邮箱：`VARCHAR(100)`
- 密码（加密后）：`VARCHAR(255)`
- 短描述：`VARCHAR(255)`
- 长描述：`VARCHAR(500)` 或 `TEXT`
- URL：`VARCHAR(500)`

#### 日期时间类型
| 类型 | 格式 | 使用场景 |
|------|------|----------|
| `DATE` | YYYY-MM-DD | 日期（出生日期、纪念日） |
| `TIME` | HH:MM:SS | 时间 |
| `DATETIME` | YYYY-MM-DD HH:MM:SS | 日期时间（推荐用于审计字段） |
| `TIMESTAMP` | 时间戳 | 自动更新的时间戳 |

#### 数值类型
| 类型 | 使用场景 |
|------|----------|
| `DECIMAL(M,D)` | 精确数值（金额、汇率等） |
| `FLOAT` | 浮点数（不推荐用于金额） |
| `DOUBLE` | 双精度浮点数 |

金额字段建议：`DECIMAL(19,2)` 或 `DECIMAL(10,2)`

#### 其他类型
| 类型 | 使用场景 |
|------|----------|
| `JSON` | JSON 数据 |
| `ENUM` | 枚举值（谨慎使用，建议用 TINYINT + 注释） |
| `BLOB` | 二进制数据（不推荐存储文件，建议存储路径） |

### 索引设计规范

#### 索引类型
1. **主键索引 (PRIMARY KEY)**
   - 每个表必须有主键
   - 推荐使用自增 `BIGINT` 类型
   - 命名为 `id`

2. **唯一索引 (UNIQUE)**
   - 用于保证字段唯一性（如用户名、邮箱、手机号等）
   - 可以是单列或多列联合唯一索引

3. **普通索引 (INDEX)**
   - 为常用查询字段建立索引
   - 外键字段建议建立索引
   - WHERE、JOIN、ORDER BY、GROUP BY 中的字段考虑建立索引

4. **全文索引 (FULLTEXT)**
   - 用于全文搜索
   - 适用于 `CHAR`、`VARCHAR`、`TEXT` 类型

#### 索引设计原则
- ✅ 选择性高的字段优先建立索引
- ✅ 频繁查询的字段建立索引
- ✅ 合理使用联合索引（注意最左前缀原则）
- ✅ 控制单表索引数量（建议不超过 5 个）
- ✅ 字符串字段考虑前缀索引
- ❌ 避免对低选择性字段建索引（如性别、状态等值很少的字段）
- ❌ 避免过度索引，影响写入性能
- ❌ 避免冗余索引

#### 联合索引设计
遵循**最左前缀原则**：

```sql
-- 创建联合索引
INDEX idx_user_status_time (user_id, status, create_time)

-- 可以使用的查询（从左开始）
WHERE user_id = ?
WHERE user_id = ? AND status = ?
WHERE user_id = ? AND status = ? AND create_time > ?

-- 不能使用的查询（跳过了最左）
WHERE status = ?
WHERE create_time > ?
WHERE status = ? AND create_time > ?
```

### 约束规范

#### 主键约束
- 每个表必须有主键
- 推荐使用自增整数主键
- 不推荐使用业务字段作为主键

#### 外键约束
- 根据业务需求决定是否使用外键约束
- 高并发场景可以不使用物理外键，通过应用层维护
- 如果使用外键，需要考虑级联更新和删除策略

#### 非空约束
- 根据业务需求设置 `NOT NULL`
- 重要字段建议设置 `NOT NULL` 并提供默认值
- 可空字段在查询时注意 `NULL` 值处理

#### 默认值
- 为字段提供合理的默认值
- 常见默认值：
  - 状态字段：`DEFAULT 0` 或 `DEFAULT 1`
  - 删除标记：`DEFAULT 0`
  - 排序号：`DEFAULT 0`
  - 时间字段：`DEFAULT CURRENT_TIMESTAMP`
  - 更新时间：`DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP`

### 注释规范

#### 表注释
- 每个表必须添加表注释
- 使用清晰的中文说明
- 说明表的业务用途

```sql
CREATE TABLE `sys_user` (
    ...
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';
```

#### 字段注释
- 每个字段必须添加字段注释
- 使用清晰的中文说明
- 状态、枚举字段应在注释中说明各值的含义

```sql
`status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
`type` TINYINT NOT NULL COMMENT '用户类型：1-普通用户，2-VIP用户，3-管理员',
`deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '删除标记：0-未删除，1-已删除'
```

### 字符集和排序规则

- **字符集**：统一使用 `utf8mb4`（支持 emoji 等 4 字节字符）
- **排序规则**：
  - 一般使用 `utf8mb4_0900_ai_ci`（不区分大小写）
  - 需要区分大小写时使用 `utf8mb4_bin`
  - 中文排序可使用 `utf8mb4_zh_0900_as_cs`（MySQL 8.0+）

```sql
CREATE TABLE `example` (
    ...
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

### 存储引擎

- **推荐**：`InnoDB`
  - 支持事务
  - 支持外键
  - 支持行级锁
  - 自动灾难恢复

- **不推荐**：`MyISAM`
  - 不支持事务
  - 不支持外键
  - 仅支持表级锁

```sql
CREATE TABLE `example` (
    ...
) ENGINE=InnoDB;
```

### 软删除设计

推荐使用逻辑删除（软删除）而非物理删除：

```sql
`deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '删除标记：0-未删除，1-已删除',
`delete_time` DATETIME NULL COMMENT '删除时间',
`delete_user` BIGINT NULL COMMENT '删除人'
```

查询时需要添加条件：
```sql
WHERE deleted = 0
```

---

## 表结构设计示例

### 示例 1：系统用户表

```sql
CREATE TABLE `sys_user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键 ID',
    `username` VARCHAR(50) NOT NULL COMMENT '用户名',
    `password` VARCHAR(255) NOT NULL COMMENT '密码（加密）',
    `nickname` VARCHAR(50) NULL COMMENT '昵称',
    `email` VARCHAR(100) NULL COMMENT '邮箱',
    `phone` VARCHAR(20) NULL COMMENT '手机号',
    `avatar` VARCHAR(500) NULL COMMENT '头像 URL',
    `gender` TINYINT NULL COMMENT '性别：0-未知，1-男，2-女',
    `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '删除标记：0-未删除，1-已删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_user` BIGINT NULL COMMENT '创建人',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_user` BIGINT NULL COMMENT '更新人',
    `remark` VARCHAR(500) NULL COMMENT '备注',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_username` (`username`),
    UNIQUE KEY `uni_email` (`email`),
    UNIQUE KEY `uni_phone` (`phone`),
    KEY `idx_status` (`status`),
    KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统用户表';
```

### 示例 2：系统角色表

```sql
CREATE TABLE `sys_role` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键 ID',
    `role_name` VARCHAR(50) NOT NULL COMMENT '角色名称',
    `role_code` VARCHAR(50) NOT NULL COMMENT '角色编码',
    `description` VARCHAR(255) NULL COMMENT '角色描述',
    `sort` INT NOT NULL DEFAULT 0 COMMENT '排序号',
    `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '删除标记：0-未删除，1-已删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_user` BIGINT NULL COMMENT '创建人',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_user` BIGINT NULL COMMENT '更新人',
    `remark` VARCHAR(500) NULL COMMENT '备注',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_role_code` (`role_code`),
    KEY `idx_status_sort` (`status`, `sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色表';
```

### 示例 3：用户角色关联表

```sql
CREATE TABLE `sys_user_role` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键 ID',
    `user_id` BIGINT NOT NULL COMMENT '用户 ID',
    `role_id` BIGINT NOT NULL COMMENT '角色 ID',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_user` BIGINT NULL COMMENT '创建人',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_user_role` (`user_id`, `role_id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色关联表';
```

---

## 设计建议

### 1. 主键设计
- ✅ **推荐**：使用自增整型 `BIGINT` 作为主键，命名为 `id`
- ✅ **可选**：使用雪花算法生成的分布式 ID（`BIGINT`）
- ❌ **不推荐**：使用 UUID（占用空间大，索引效率低）
- ❌ **不推荐**：使用业务字段作为主键（可能变更）

### 2. 审计字段
建议每个表都包含以下审计字段，便于追踪数据变更：
- `create_time`：创建时间
- `create_user`：创建人
- `update_time`：更新时间
- `update_user`：更新人

### 3. 逻辑删除
- 推荐使用逻辑删除而非物理删除
- 使用 `deleted` 字段标识是否删除
- 可选添加 `delete_time` 和 `delete_user` 字段

### 4. 状态字段
- 使用 `TINYINT` 类型存储状态
- 在注释中明确说明各状态值的含义
- 提供合理的默认值


### 6. 字符集
- 统一使用 `utf8mb4` 字符集
- 支持存储 emoji 等特殊字符
- 使用 `utf8mb4_0900_ai_ci` 排序规则

### 7. 存储引擎
- 统一使用 `InnoDB` 存储引擎
- 支持事务、外键、行级锁

### 8. 注释规范
- 每个表和字段都必须添加清晰的中文注释
- 状态、枚举字段要说明各值的含义

### 9. 索引优化
- 根据查询场景合理建立索引
- 避免过度索引影响写入性能
- 定期分析和优化索引

---

## 检查清单

在创建新表之前，请检查以下事项：

### 表结构
- [ ] 表名符合命名规范（小写、下划线分隔、有业务前缀）
- [ ] 有清晰的表注释
- [ ] 有主键 `id`（BIGINT 自增）
- [ ] 包含审计字段（create_time, update_time 等）
- [ ] 包含逻辑删除字段 `deleted`
- [ ] 使用 InnoDB 存储引擎
- [ ] 使用 utf8mb4 字符集

### 字段设计
- [ ] 字段名符合命名规范（小写、下划线分隔）
- [ ] 每个字段都有注释
- [ ] 状态字段说明了各值的含义
- [ ] 数据类型选择合理
- [ ] 字符串字段长度合适
- [ ] 金额字段使用 DECIMAL
- [ ] 必填字段设置了 NOT NULL
- [ ] 提供了合理的默认值

### 索引设计
- [ ] 有主键索引
- [ ] 唯一性字段建立了唯一索引
- [ ] 外键字段建立了索引
- [ ] 常用查询字段建立了索引
- [ ] 没有冗余索引
- [ ] 索引数量合理（不超过 5 个）

### 约束设计
- [ ] 主键约束正确
- [ ] 唯一约束正确
- [ ] 外键约束正确（如果使用）
- [ ] 非空约束合理

---

## 参考资料

- [MySQL 官方文档](https://dev.mysql.com/doc/)
- [阿里巴巴 Java 开发手册 - MySQL 数据库规约](https://developer.aliyun.com/special/tech-java)
- [MySQL 索引优化最佳实践](https://dev.mysql.com/doc/refman/8.0/en/optimization-indexes.html)
- [数据库设计三大范式](https://zh.wikipedia.org/wiki/数据库规范化)

---

## 附录

### 常用 SQL 模板

#### 1. 创建表模板

```sql
CREATE TABLE `{table_name}` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键 ID',
    -- 业务字段
    `name` VARCHAR(100) NOT NULL COMMENT '名称',
    -- 通用字段
    `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `sort` INT NOT NULL DEFAULT 0 COMMENT '排序号',
    `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '删除标记：0-未删除，1-已删除',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_user` BIGINT NULL COMMENT '创建人',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_user` BIGINT NULL COMMENT '更新人',
    `remark` VARCHAR(500) NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='{table_comment}';
```

#### 2. 添加字段

```sql
ALTER TABLE `{table_name}` 
ADD COLUMN `{column_name}` {data_type} COMMENT '{comment}' AFTER `{after_column}`;
```

#### 3. 修改字段

```sql
ALTER TABLE `{table_name}` 
MODIFY COLUMN `{column_name}` {new_data_type} COMMENT '{new_comment}';
```

#### 4. 添加索引

```sql
-- 普通索引
ALTER TABLE `{table_name}` ADD INDEX `idx_{column_name}` (`{column_name}`);

-- 唯一索引
ALTER TABLE `{table_name}` ADD UNIQUE INDEX `uni_{column_name}` (`{column_name}`);

-- 联合索引
ALTER TABLE `{table_name}` ADD INDEX `idx_{col1}_{col2}` (`{col1}`, `{col2}`);
```

#### 5. 删除索引

```sql
ALTER TABLE `{table_name}` DROP INDEX `{index_name}`;
```

---

*本文档将在运行分析工具后自动填充实际的表结构信息*

*最后更新时间：2026-01-04*

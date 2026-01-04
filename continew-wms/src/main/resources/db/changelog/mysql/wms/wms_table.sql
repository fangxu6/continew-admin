-- liquibase formatted sql

-- changeset speckit:1
-- comment 初始化 WMS 模块表结构

CREATE TABLE IF NOT EXISTS `wms_customer` (
    `id`          bigint(20)   AUTO_INCREMENT              COMMENT 'ID',
    `code`        varchar(64)  NOT NULL                    COMMENT '客户编码，唯一，必填',
    `name`        varchar(255) NOT NULL                    COMMENT '客户名称，必填',
    `contact`     varchar(100) DEFAULT NULL                COMMENT '联系人',
    `phone`       varchar(20)  DEFAULT NULL                COMMENT '联系电话',
    `email`       varchar(100) DEFAULT NULL                COMMENT '邮箱',
    `address`     varchar(500) DEFAULT NULL                COMMENT '地址',
    `status`      varchar(32)  NOT NULL DEFAULT 'ENABLE'   COMMENT '客户状态: ENABLE-启用, DISABLE-禁用',
    `credit_level` varchar(32)  DEFAULT NULL                COMMENT '信用等级',
    `remark`      text         DEFAULT NULL                COMMENT '备注',
    `create_user` bigint(20)   NOT NULL                    COMMENT '创建人',
    `create_time` datetime     NOT NULL                    COMMENT '创建时间',
    `update_user` bigint(20)   DEFAULT NULL                COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL                COMMENT '修改时间',
    `deleted`     bigint(20)   NOT NULL DEFAULT 0          COMMENT '是否已删除（0：否；id：是）',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uni_wms_customer_code` (`code`),
    INDEX `idx_wms_customer_name` (`name`),
    INDEX `idx_wms_customer_status` (`status`),
    INDEX `idx_wms_customer_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户表';

CREATE TABLE IF NOT EXISTS `wms_supplier` (
    `id`          bigint(20)   AUTO_INCREMENT              COMMENT 'ID',
    `code`        varchar(64)  NOT NULL                    COMMENT '供应商编码，唯一，必填',
    `name`        varchar(255) NOT NULL                    COMMENT '供应商名称，必填',
    `contact`     varchar(100) DEFAULT NULL                COMMENT '联系人',
    `phone`       varchar(20)  DEFAULT NULL                COMMENT '联系电话',
    `email`       varchar(100) DEFAULT NULL                COMMENT '邮箱',
    `address`     varchar(500) DEFAULT NULL                COMMENT '地址',
    `status`      varchar(32)  NOT NULL DEFAULT 'ENABLE'   COMMENT '供应商状态: ENABLE-启用, DISABLE-禁用',
    `credit_level` varchar(32)  DEFAULT NULL                COMMENT '信用等级',
    `remark`      text         DEFAULT NULL                COMMENT '备注',
    `create_user` bigint(20)   NOT NULL                    COMMENT '创建人',
    `create_time` datetime     NOT NULL                    COMMENT '创建时间',
    `update_user` bigint(20)   DEFAULT NULL                COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL                COMMENT '修改时间',
    `deleted`     bigint(20)   NOT NULL DEFAULT 0          COMMENT '是否已删除（0：否；id：是）',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uni_wms_supplier_code` (`code`),
    INDEX `idx_wms_supplier_name` (`name`),
    INDEX `idx_wms_supplier_status` (`status`),
    INDEX `idx_wms_supplier_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='供应商表';

CREATE TABLE IF NOT EXISTS `wms_warehouse` (
    `id`          bigint(20)   AUTO_INCREMENT              COMMENT 'ID',
    `code`        varchar(64)  NOT NULL                    COMMENT '仓库编码，唯一，必填',
    `name`        varchar(255) NOT NULL                    COMMENT '仓库名称，必填',
    `address`     varchar(500) DEFAULT NULL                COMMENT '仓库地址',
    `manager`     varchar(100) DEFAULT NULL                COMMENT '仓库管理员',
    `manager_id`  bigint(20)   DEFAULT NULL                COMMENT '仓库管理员ID',
    `status`      varchar(32)  NOT NULL DEFAULT 'ENABLE'   COMMENT '仓库状态: ENABLE-启用, DISABLE-禁用',
    `remark`      text         DEFAULT NULL                COMMENT '备注',
    `create_user` bigint(20)   NOT NULL                    COMMENT '创建人',
    `create_time` datetime     NOT NULL                    COMMENT '创建时间',
    `update_user` bigint(20)   DEFAULT NULL                COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL                COMMENT '修改时间',
    `deleted`     bigint(20)   NOT NULL DEFAULT 0          COMMENT '是否已删除（0：否；id：是）',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uni_wms_warehouse_code` (`code`),
    INDEX `idx_wms_warehouse_name` (`name`),
    INDEX `idx_wms_warehouse_status` (`status`),
    INDEX `idx_wms_warehouse_manager_id` (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='仓库表';

CREATE TABLE IF NOT EXISTS `wms_item` (
    `id`          bigint(20)   AUTO_INCREMENT              COMMENT 'ID',
    `code`        varchar(64)  NOT NULL                    COMMENT '物品编码，唯一，必填',
    `name`        varchar(255) NOT NULL                    COMMENT '物品名称，必填',
    `description` text         DEFAULT NULL                COMMENT '物品描述',
    `category`    varchar(64)  DEFAULT NULL                COMMENT '物品类别',
    `unit`        varchar(32)  NOT NULL                    COMMENT '计量单位',
    `length`      decimal(10,2) DEFAULT NULL               COMMENT '长度',
    `width`       decimal(10,2) DEFAULT NULL               COMMENT '宽度',
    `height`      decimal(10,2) DEFAULT NULL               COMMENT '高度',
    `weight`      decimal(10,2) DEFAULT NULL               COMMENT '重量',
    `status`      varchar(32)  NOT NULL DEFAULT 'ENABLE'   COMMENT '物品状态: ENABLE-启用, DISABLE-禁用',
    `create_user` bigint(20)   NOT NULL                    COMMENT '创建人',
    `create_time` datetime     NOT NULL                    COMMENT '创建时间',
    `update_user` bigint(20)   DEFAULT NULL                COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL                COMMENT '修改时间',
    `deleted`     bigint(20)   NOT NULL DEFAULT 0          COMMENT '是否已删除（0：否；id：是）',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uni_wms_item_code` (`code`),
    INDEX `idx_wms_item_name` (`name`),
    INDEX `idx_wms_item_category` (`category`),
    INDEX `idx_wms_item_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物品表';

CREATE TABLE IF NOT EXISTS `wms_location` (
    `id`             bigint(20)    AUTO_INCREMENT              COMMENT 'ID',
    `code`           varchar(64)   NOT NULL                    COMMENT '位置编码，唯一，必填',
    `name`           varchar(255)  NOT NULL                    COMMENT '位置名称，必填',
    `warehouse_id`   bigint(20)    NOT NULL                    COMMENT '所属仓库ID，必填',
    `area`           varchar(64)   DEFAULT NULL                COMMENT '所属区域',
    `row`            varchar(32)   DEFAULT NULL                COMMENT '排',
    `column`         varchar(32)   DEFAULT NULL                COMMENT '列',
    `level`          varchar(32)   DEFAULT NULL                COMMENT '层',
    `position`       varchar(32)   DEFAULT NULL                COMMENT '位',
    `type`           varchar(32)   DEFAULT NULL                COMMENT '位置类型: STORAGE-存储, PICKING-拣选, RECEIVING-收货, SHIPPING-发货',
    `capacity`       decimal(15,2) DEFAULT NULL                COMMENT '容量',
    `used_capacity`  decimal(15,2) DEFAULT NULL                COMMENT '已用容量',
    `status`         varchar(32)   NOT NULL DEFAULT 'AVAILABLE' COMMENT '位置状态: AVAILABLE-可用, UNAVAILABLE-不可用, LOCKED-锁定',
    `remark`         text          DEFAULT NULL                COMMENT '备注',
    `create_user` bigint(20)   NOT NULL                    COMMENT '创建人',
    `create_time` datetime     NOT NULL                    COMMENT '创建时间',
    `update_user` bigint(20)   DEFAULT NULL                COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL                COMMENT '修改时间',
    `deleted`     bigint(20)   NOT NULL DEFAULT 0          COMMENT '是否已删除（0：否；id：是）',

    PRIMARY KEY (`id`),
    UNIQUE INDEX `uni_wms_location_code` (`code`),
    INDEX `idx_wms_location_warehouse_id` (`warehouse_id`),
    INDEX `idx_wms_location_name` (`name`),
    INDEX `idx_wms_location_type` (`type`),
    INDEX `idx_wms_location_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='位置表';
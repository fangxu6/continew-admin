-- liquibase formatted sql

-- changeset speckit:1
-- comment 初始化 WMS 模块表数据

-- 初始化客户数据
INSERT INTO `wms_customer`
(`id`, `code`, `name`, `contact`, `phone`, `email`, `address`, `status`, `credit_level`, `remark`, `deleted`, `create_time`, `update_time`, `create_user`, `update_user`)
VALUES
(1, 'CUST001', '北京科技有限公司', '张经理', '13800138001', 'contact@beijingtech.com', '北京市朝阳区xxx街道xxx号', 'ENABLE', 'A', '重要客户', 0, NOW(), NOW(), 1, 1),
(2, 'CUST002', '上海贸易有限公司', '李经理', '13800138002', 'info@shanghaitrade.com', '上海市浦东新区xxx路xxx号', 'ENABLE', 'B', '长期合作客户', 0, NOW(), NOW(), 1, 1),
(3, 'CUST003', '广州制造有限公司', '王经理', '13800138003', 'sales@gzmfg.com', '广州市天河区xxx大道xxx号', 'ENABLE', 'A', 'VIP客户', 0, NOW(), NOW(), 1, 1),
(4, 'CUST004', '深圳电子有限公司', '赵经理', '13800138004', 'service@szelectronics.com', '深圳市南山区xxx科技园xxx栋', 'DISABLE', 'C', '暂停合作', 0, NOW(), NOW(), 1, 1),
(5, 'CUST005', '杭州网络有限公司', '刘经理', '13800138005', 'support@hznw.com', '杭州市西湖区xxx路xxx号', 'ENABLE', 'B', '潜力客户', 0, NOW(), NOW(), 1, 1);

-- 初始化供应商数据
INSERT INTO `wms_supplier`
(`id`, `code`, `name`, `contact`, `phone`, `email`, `address`, `status`, `credit_level`, `remark`, `deleted`, `create_time`, `update_time`, `create_user`, `update_user`)
VALUES
(1, 'SUP001', '华强北电子有限公司', '陈经理', '13900139001', 'purchase@hqbei.com', '深圳市福田区华强北路xxx号', 'ENABLE', 'A', '优质供应商', 0, NOW(), NOW(), 1, 1),
(2, 'SUP002', '东莞制造有限公司', '黄经理', '13900139002', 'supply@dgmfg.com', '东莞市虎门镇xxx工业区', 'ENABLE', 'A', '长期合作伙伴', 0, NOW(), NOW(), 1, 1),
(3, 'SUP003', '苏州精密有限公司', '周经理', '13900139003', 'sales@suzhouprecision.com', '苏州市工业园区xxx路xxx号', 'ENABLE', 'B', '精密器件供应商', 0, NOW(), NOW(), 1, 1),
(4, 'SUP004', '成都科技有限公司', '吴经理', '13900139004', 'info@chengduitk.com', '成都市高新区xxx园区xxx栋', 'DISABLE', 'C', '暂停供应', 0, NOW(), NOW(), 1, 1),
(5, 'SUP005', '武汉材料有限公司', '郑经理', '13900139005', 'material@whmaterial.com', '武汉市江汉区xxx工业城', 'ENABLE', 'B', '原材料供应商', 0, NOW(), NOW(), 1, 1);

-- 初始化仓库数据
INSERT INTO `wms_warehouse`
(`id`, `code`, `name`, `address`, `manager`, `manager_id`, `status`, `remark`, `deleted`, `create_time`, `update_time`, `create_user`, `update_user`)
VALUES
(1, 'WH001', '北京仓', '北京市顺义区物流园xxx号', '张仓库', 547889293968801823, 'ENABLE', '华北地区主要仓库', 0, NOW(), NOW(), 1, 1),
(2, 'WH002', '上海仓', '上海市浦东新区物流大道xxx号', '李仓库', 547889293968801825, 'ENABLE', '华东地区主要仓库', 0, NOW(), NOW(), 1, 1),
(3, 'WH003', '广州仓', '广州市白云区物流园xxx号', '王仓库', 547889293968801827, 'ENABLE', '华南地区主要仓库', 0, NOW(), NOW(), 1, 1),
(4, 'WH004', '深圳仓', '深圳市龙岗区仓储物流园xxx号', '赵仓库', 547889293968801830, 'DISABLE', '华南备货仓库', 0, NOW(), NOW(), 1, 1),
(5, 'WH005', '成都仓', '成都市双流区航空港物流园xxx号', '刘仓库', 547889293968801832, 'ENABLE', '西南地区主要仓库', 0, NOW(), NOW(), 1, 1);

-- 初始化物料数据
INSERT INTO `wms_item`
(`id`, `code`, `name`, `description`, `category`, `unit`, `length`, `width`, `height`, `weight`, `status`, `deleted`, `create_time`, `update_time`, `create_user`, `update_user`)
VALUES
(1, 'ITEM001', '服务器CPU', '高性能服务器处理器，适用于数据中心', 'Hardware', '个', 7.50, 7.50, 2.00, 0.25, 'ENABLE', 0, NOW(), NOW(), 1, 1),
(2, 'ITEM002', '固态硬盘', '企业级SSD，容量1TB，高速读写', 'Hardware', '个', 2.75, 1.00, 0.25, 0.06, 'ENABLE', 0, NOW(), NOW(), 1, 1),
(3, 'ITEM003', '内存条', 'DDR4 32GB 服务器内存', 'Hardware', '个', 13.00, 1.70, 0.20, 0.04, 'ENABLE', 0, NOW(), NOW(), 1, 1),
(4, 'ITEM004', '笔记本电脑', '商务办公笔记本电脑', 'Electronics', '台', 35.00, 24.00, 2.00, 1.50, 'ENABLE', 0, NOW(), NOW(), 1, 1),
(5, 'ITEM005', '办公椅', '人体工学办公椅', 'Furniture', '把', 60.00, 60.00, 120.00, 8.00, 'ENABLE', 0, NOW(), NOW(), 1, 1),
(6, 'ITEM006', '激光打印机', '商用激光打印机', 'Electronics', '台', 40.00, 35.00, 25.00, 12.00, 'ENABLE', 0, NOW(), NOW(), 1, 1),
(7, 'ITEM007', '显示器', '27寸4K高清显示器', 'Electronics', '台', 62.00, 20.00, 45.00, 5.50, 'ENABLE', 0, NOW(), NOW(), 1, 1),
(8, 'ITEM008', '无线鼠标', '蓝牙无线鼠标', 'Accessories', '个', 12.00, 7.00, 4.00, 0.10, 'ENABLE', 0, NOW(), NOW(), 1, 1);

-- 初始化库位数据
INSERT INTO `wms_location`
(`id`, `code`, `name`, `warehouse_id`, `area`, `row`, `column`, `level`, `position`, `type`, `capacity`, `used_capacity`, `status`, `remark`, `deleted`, `create_time`, `update_time`, `create_user`, `update_user`)
VALUES
(1, 'WH001-A-01-01-01', '北京仓A区01排01列01层', 1, 'A区', '01', '01', '01', '01', 'STORAGE', 100.00, 60.00, 'OCCUPIED', 'A区首排首列', 0, NOW(), NOW(), 1, 1),
(2, 'WH001-A-01-01-02', '北京仓A区01排01列02层', 1, 'A区', '01', '01', '02', '02', 'STORAGE', 100.00, 30.00, 'OCCUPIED', 'A区首排首列二层', 0, NOW(), NOW(), 1, 1),
(3, 'WH001-A-02-01-01', '北京仓A区02排01列01层', 1, 'A区', '02', '01', '01', '01', 'STORAGE', 100.00, 0.00, 'AVAILABLE', 'A区二排首列', 0, NOW(), NOW(), 1, 1),
(4, 'WH001-B-01-01-01', '北京仓B区01排01列01层', 1, 'B区', '01', '01', '01', '01', 'STORAGE', 200.00, 150.00, 'OCCUPIED', 'B区首排首列', 0, NOW(), NOW(), 1, 1),
(5, 'WH001-B-02-01-01', '北京仓B区02排01列01层', 1, 'B区', '02', '01', '01', '01', 'RECEIVING', 150.00, 0.00, 'AVAILABLE', 'B区收货区', 0, NOW(), NOW(), 1, 1),
(6, 'WH002-A-01-01-01', '上海仓A区01排01列01层', 2, 'A区', '01', '01', '01', '01', 'STORAGE', 100.00, 80.00, 'OCCUPIED', 'A区首排首列', 0, NOW(), NOW(), 1, 1),
(7, 'WH002-B-01-01-01', '上海仓B区01排01列01层', 2, 'B区', '01', '01', '01', '01', 'STORAGE', 200.00, 120.00, 'OCCUPIED', 'B区首排首列', 0, NOW(), NOW(), 1, 1),
(8, 'WH002-C-01-01-01', '上海仓C区01排01列01层', 2, 'C区', '01', '01', '01', '01', 'PICKING', 80.00, 0.00, 'AVAILABLE', 'C区拣货区', 0, NOW(), NOW(), 1, 1),
(9, 'WH003-A-01-01-01', '广州仓A区01排01列01层', 3, 'A区', '01', '01', '01', '01', 'STORAGE', 100.00, 90.00, 'OCCUPIED', 'A区首排首列', 0, NOW(), NOW(), 1, 1),
(10, 'WH003-D-01-01-01', '广州仓D区01排01列01层', 3, 'D区', '01', '01', '01', '01', 'SHIPPING', 120.00, 0.00, 'AVAILABLE', 'D区发货区', 0, NOW(), NOW(), 1, 1);
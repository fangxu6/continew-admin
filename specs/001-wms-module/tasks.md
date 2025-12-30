# Tasks: WMS模块

**Input**: Design documents from `/specs/001-wms-module/`
**Prerequisites**: plan.md (required), spec.md (required for user stories), research.md, data-model.md, contracts/

**Tests**: The examples below include test tasks. Tests are OPTIONAL - only include them if explicitly requested in the feature specification.

**Organization**: Tasks are grouped by user story to enable independent implementation and testing of each story.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: Which user story this task belongs to (e.g., US1, US2, US3)
- Include exact file paths in descriptions

## Path Conventions

- **Single project**: `src/`, `tests/` at repository root
- **Web app**: `backend/src/`, `frontend/src/`
- **Mobile**: `api/src/`, `ios/src/` or `android/src/`
- Paths shown below assume single project - adjust based on plan.md structure

---

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Project initialization and basic structure

- [X] T001 Create continew-wms module directory structure per implementation plan
- [X] T002 Initialize Java 17 project with Spring Boot 3.3.12 dependencies in continew-wms/pom.xml
- [X] T003 [P] Configure Maven dependencies for MyBatis Plus, Sa-Token, Redisson, FastExcel, Crane4j, SpringDoc, Hutool
- [X] T004 [P] Configure project-wide code formatting and linting tools following Alibaba Java Coding Guidelines

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Core infrastructure that MUST be complete before ANY user story can be implemented

**⚠️ CRITICAL**: No user story work can begin until this phase is complete

Foundational tasks for WMS module:

- [X] T005 Setup database schema and migrations framework for WMS module in src/main/resources/db/changelog/mysql/wms/
- [X] T006 [P] Configure MySQL 8.0.42 database connection for WMS module in application.yml
- [X] T007 [P] Setup MyBatis Plus configuration for WMS module in continew-wms/src/main/java/top/continew/admin/wms/config/
- [X] T008 Create base entities, DTOs, and enums that all stories depend on
- [X] T009 Configure error handling and logging infrastructure for WMS module
- [X] T010 Setup environment configuration management for WMS module in continew-wms/src/main/java/top/continew/admin/wms/config/WmsConfig.java
- [X] T011 [P] Implement common validation utilities for WMS module in continew-wms/src/main/java/top/continew/admin/wms/validation/
- [X] T012 [P] Create base controller with common functionality in continew-wms/src/main/java/top/continew/admin/wms/controller/BaseController.java

**Checkpoint**: Foundation ready - user story implementation can now begin in parallel

---

## Phase 3: User Story 1 - 基础仓库数据管理 (Priority: P1) 🎯 MVP

**Goal**: Implement basic warehouse data management including items, locations, suppliers, and customers

**Independent Test**: Can be fully tested by creating items, locations, suppliers, and customers in the system and verifying they can be retrieved, updated, and searched.

### Implementation for User Story 1

- [X] T013 [P] [US1] Create Item entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Item.java
- [X] T014 [P] [US1] Create Location entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Location.java
- [X] T015 [P] [US1] Create Supplier entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Supplier.java
- [X] T016 [P] [US1] Create Customer entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Customer.java
- [X] T017 [P] [US1] Create Warehouse entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Warehouse.java
- [X] T018 [P] [US1] Create ItemReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/ItemReq.java
- [X] T019 [P] [US1] Create LocationReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/LocationReq.java
- [X] T020 [P] [US1] Create SupplierReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/SupplierReq.java
- [X] T021 [P] [US1] Create CustomerReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/CustomerReq.java
- [X] T022 [P] [US1] Create ItemResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/ItemResp.java
- [X] T023 [P] [US1] Create LocationResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/LocationResp.java
- [X] T024 [P] [US1] Create SupplierResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/SupplierResp.java
- [X] T025 [P] [US1] Create CustomerResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/CustomerResp.java
- [X] T026 [P] [US1] Create ItemQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/ItemQuery.java
- [X] T027 [P] [US1] Create LocationQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/LocationQuery.java
- [X] T028 [P] [US1] Create SupplierQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/SupplierQuery.java
- [X] T029 [P] [US1] Create CustomerQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/CustomerQuery.java
- [X] T030 [P] [US1] Create ItemMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/ItemMapper.java
- [X] T031 [P] [US1] Create LocationMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/LocationMapper.java
- [X] T032 [P] [US1] Create SupplierMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/SupplierMapper.java
- [X] T033 [P] [US1] Create CustomerMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/CustomerMapper.java
- [X] T034 [P] [US1] Create WarehouseMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/WarehouseMapper.java
- [X] T035 [US1] Create ItemService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/ItemService.java
- [X] T036 [US1] Create LocationService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/LocationService.java
- [X] T037 [US1] Create SupplierService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/SupplierService.java
- [X] T038 [US1] Create CustomerService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/CustomerService.java
- [X] T039 [US1] Create WarehouseService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/WarehouseService.java
- [X] T040 [US1] Create ItemController in continew-wms/src/main/java/top/continew/admin/wms/controller/ItemController.java
- [X] T041 [US1] Create LocationController in continew-wms/src/main/java/top/continew/admin/wms/controller/LocationController.java
- [X] T042 [US1] Create SupplierController in continew-wms/src/main/java/top/continew/admin/wms/controller/SupplierController.java
- [X] T043 [US1] Create CustomerController in continew-wms/src/main/java/top/continew/admin/wms/controller/CustomerController.java
- [X] T044 [US1] Create WarehouseController in continew-wms/src/main/java/top/continew/admin/wms/controller/WarehouseController.java
- [X] T045 [US1] Implement ItemMapper.xml in continew-wms/src/main/resources/mapper/ItemMapper.xml
- [X] T046 [US1] Implement LocationMapper.xml in continew-wms/src/main/resources/mapper/LocationMapper.xml
- [X] T047 [US1] Implement SupplierMapper.xml in continew-wms/src/main/resources/mapper/SupplierMapper.xml
- [X] T048 [US1] Implement CustomerMapper.xml in continew-wms/src/main/resources/mapper/CustomerMapper.xml
- [X] T049 [US1] Implement WarehouseMapper.xml in continew-wms/src/main/resources/mapper/WarehouseMapper.xml
- [X] T050 [US1] Add validation and error handling to all basic data management endpoints
- [X] T051 [US1] Add logging for basic data management operations
- [X] T052 [US1] Create ItemQuery query implementation in continew-wms/src/main/java/top/continew/admin/wms/service/impl/ItemServiceImpl.java
- [X] T053 [US1] Create LocationQuery query implementation in continew-wms/src/main/java/top/continew/admin/wms/service/impl/LocationServiceImpl.java
- [X] T054 [US1] Create SupplierQuery query implementation in continew-wms/src/main/java/top/continew/admin/wms/service/impl/SupplierServiceImpl.java
- [X] T055 [US1] Create CustomerQuery query implementation in continew-wms/src/main/java/top/continew/admin/wms/service/impl/CustomerServiceImpl.java

**Checkpoint**: At this point, User Story 1 should be fully functional and testable independently

---

## Phase 4: User Story 2 - 入库作业操作 (Priority: P2)

**Goal**: Implement goods receipt operations including receiving shipments, verifying quantities, and updating inventory levels

**Independent Test**: Can be fully tested by creating receipt orders, processing incoming shipments, and verifying that inventory levels are correctly updated.

### Implementation for User Story 2

- [ ] T056 [P] [US2] Create ReceiptOrder entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/ReceiptOrder.java
- [ ] T057 [P] [US2] Create ReceiptOrderItem entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/ReceiptOrderItem.java
- [ ] T058 [P] [US2] Create ReceiptOrderReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/ReceiptOrderReq.java
- [ ] T059 [P] [US2] Create ReceiptOrderDetailResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/ReceiptOrderDetailResp.java
- [ ] T060 [P] [US2] Create ReceiptOrderQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/ReceiptOrderQuery.java
- [ ] T061 [P] [US2] Create ReceiptOrderMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/ReceiptOrderMapper.java
- [ ] T062 [P] [US2] Create ReceiptOrderItemMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/ReceiptOrderItemMapper.java
- [ ] T063 [US2] Create ReceiptOrderService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/ReceiptOrderService.java
- [ ] T064 [US2] Create ReceiptOrderController in continew-wms/src/main/java/top/continew/admin/wms/controller/ReceiptOrderController.java
- [ ] T065 [US2] Implement ReceiptOrderMapper.xml in continew-wms/src/main/resources/mapper/ReceiptOrderMapper.xml
- [ ] T066 [US2] Implement ReceiptOrderItemMapper.xml in continew-wms/src/main/resources/mapper/ReceiptOrderItemMapper.xml
- [ ] T067 [US2] Add inventory update logic when processing receipt orders
- [ ] T068 [US2] Add validation for receipt order creation and processing
- [ ] T069 [US2] Add discrepancy handling for quantity mismatches
- [ ] T070 [US2] Integrate with Item and Supplier entities from User Story 1

**Checkpoint**: At this point, User Stories 1 AND 2 should both work independently

---

## Phase 5: User Story 3 - 出库作业操作 (Priority: P3)

**Goal**: Implement goods dispatch operations including picking items, packing orders, and updating inventory levels

**Independent Test**: Can be fully tested by creating dispatch orders, processing outgoing shipments, and verifying that inventory levels are correctly updated.

### Implementation for User Story 3

- [ ] T071 [P] [US3] Create DispatchOrder entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/DispatchOrder.java
- [ ] T072 [P] [US3] Create DispatchOrderItem entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/DispatchOrderItem.java
- [ ] T073 [P] [US3] Create DispatchOrderReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/DispatchOrderReq.java
- [ ] T074 [P] [US3] Create DispatchOrderDetailResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/DispatchOrderDetailResp.java
- [ ] T075 [P] [US3] Create DispatchOrderQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/DispatchOrderQuery.java
- [ ] T076 [P] [US3] Create DispatchOrderMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/DispatchOrderMapper.java
- [ ] T077 [P] [US3] Create DispatchOrderItemMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/DispatchOrderItemMapper.java
- [ ] T078 [US3] Create DispatchOrderService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/DispatchOrderService.java
- [ ] T079 [US3] Create DispatchOrderController in continew-wms/src/main/java/top/continew/admin/wms/controller/DispatchOrderController.java
- [ ] T080 [US3] Implement DispatchOrderMapper.xml in continew-wms/src/main/resources/mapper/DispatchOrderMapper.xml
- [ ] T081 [US3] Implement DispatchOrderItemMapper.xml in continew-wms/src/main/resources/mapper/DispatchOrderItemMapper.xml
- [ ] T082 [US3] Add inventory update logic when processing dispatch orders
- [ ] T083 [US3] Add validation for dispatch order creation and processing
- [ ] T084 [US3] Add inventory shortage handling and alternative suggestions
- [ ] T085 [US3] Integrate with Item and Customer entities from User Story 1

**Checkpoint**: At this point, User Stories 1, 2 AND 3 should all work independently

---

## Phase 6: User Story 4 - 库存管理 (Priority: P2)

**Goal**: Implement inventory monitoring and management including viewing current stock, performing inventory counts, and managing stock adjustments

**Independent Test**: Can be fully tested by viewing inventory levels, performing stock counts, and making adjustments while ensuring data consistency.

### Implementation for User Story 4

- [ ] T086 [P] [US4] Create Inventory entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Inventory.java
- [ ] T087 [P] [US4] Create InventoryLog entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/InventoryLog.java
- [ ] T088 [P] [US4] Create InventoryReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/InventoryReq.java
- [ ] T089 [P] [US4] Create InventoryResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/InventoryResp.java
- [ ] T090 [P] [US4] Create InventoryQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/InventoryQuery.java
- [ ] T091 [P] [US4] Create InventoryMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/InventoryMapper.java
- [ ] T092 [P] [US4] Create InventoryLogMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/InventoryLogMapper.java
- [ ] T093 [US4] Create InventoryService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/InventoryService.java
- [ ] T094 [US4] Create InventoryController in continew-wms/src/main/java/top/continew/admin/wms/controller/InventoryController.java
- [ ] T095 [US4] Implement InventoryMapper.xml in continew-wms/src/main/resources/mapper/InventoryMapper.xml
- [ ] T096 [US4] Implement InventoryLogMapper.xml in continew-wms/src/main/resources/mapper/InventoryLogMapper.xml
- [ ] T097 [US4] Add inventory query by item and location endpoints
- [ ] T098 [US4] Add inventory adjustment functionality with audit trail
- [ ] T099 [US4] Add inventory movement history tracking
- [ ] T100 [US4] Integrate with Item and Location entities from User Story 1

**Checkpoint**: At this point, User Stories 1, 2, 3 AND 4 should all work independently

---

## Phase 7: User Story 5 - 库内作业操作 (Priority: P3)

**Goal**: Implement internal operations such as stock transfers, relocations, and quality control checks

**Independent Test**: Can be fully tested by creating internal movement orders, executing transfers, and verifying that location assignments are updated correctly.

### Implementation for User Story 5

- [ ] T101 [P] [US5] Create Movement entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Movement.java
- [ ] T102 [P] [US5] Create MovementReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/MovementReq.java
- [ ] T103 [P] [US5] Create MovementResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/MovementResp.java
- [ ] T104 [P] [US5] Create MovementQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/MovementQuery.java
- [ ] T105 [P] [US5] Create MovementMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/MovementMapper.java
- [ ] T106 [US5] Create MovementService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/MovementService.java
- [ ] T107 [US5] Create MovementController in continew-wms/src/main/java/top/continew/admin/wms/controller/MovementController.java
- [ ] T108 [US5] Implement MovementMapper.xml in continew-wms/src/main/resources/mapper/MovementMapper.xml
- [ ] T109 [US5] Add stock transfer functionality between locations
- [ ] T110 [US5] Add quality control check functionality
- [ ] T111 [US5] Add movement history tracking
- [ ] T112 [US5] Integrate with Item, Location, and Inventory entities from previous stories

**Checkpoint**: At this point, User Stories 1, 2, 3, 4 AND 5 should all work independently

---

## Phase 8: User Story 6 - 终端交互 (Priority: P3)

**Goal**: Implement mobile terminal interfaces with barcode scanning capability and offline functionality

**Independent Test**: Can be fully tested by using mobile terminals to scan items, confirm operations, and verify that data is synchronized with the central system.

### Implementation for User Story 6

- [ ] T113 [P] [US6] Create TerminalOperation entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/TerminalOperation.java
- [ ] T114 [P] [US6] Create TerminalOperationReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/TerminalOperationReq.java
- [ ] T115 [P] [US6] Create TerminalOperationResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/TerminalOperationResp.java
- [ ] T116 [P] [US6] Create TerminalOperationQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/TerminalOperationQuery.java
- [ ] T117 [P] [US6] Create TerminalOperationMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/TerminalOperationMapper.java
- [ ] T118 [US6] Create TerminalOperationService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/TerminalOperationService.java
- [ ] T119 [US6] Create TerminalOperationController in continew-wms/src/main/java/top/continew/admin/wms/controller/TerminalOperationController.java
- [ ] T120 [US6] Implement TerminalOperationMapper.xml in continew-wms/src/main/resources/mapper/TerminalOperationMapper.xml
- [ ] T121 [US6] Add barcode scanning API endpoints
- [ ] T122 [US6] Add offline operation synchronization mechanism
- [ ] T123 [US6] Add real-time data synchronization for terminal operations
- [ ] T124 [US6] Integrate with all previous entities for terminal-based operations

**Checkpoint**: At this point, User Stories 1, 2, 3, 4, 5 AND 6 should all work independently

---

## Phase 9: User Story 7 - 接口集成 (Priority: P4)

**Goal**: Implement integration with external systems via standardized APIs

**Independent Test**: Can be fully tested by connecting to external systems and verifying data synchronization works correctly.

### Implementation for User Story 7

- [ ] T125 [P] [US7] Create ExternalSystem entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/ExternalSystem.java
- [ ] T126 [P] [US7] Create IntegrationConfig entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/IntegrationConfig.java
- [ ] T127 [P] [US7] Create ExternalSystemReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/ExternalSystemReq.java
- [ ] T128 [P] [US7] Create IntegrationConfigReq DTO in continew-wms/src/main/java/top/continew/admin/wms/model/req/IntegrationConfigReq.java
- [ ] T129 [P] [US7] Create ExternalSystemResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/ExternalSystemResp.java
- [ ] T130 [P] [US7] Create IntegrationConfigResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/IntegrationConfigResp.java
- [ ] T131 [P] [US7] Create ExternalSystemMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/ExternalSystemMapper.java
- [ ] T132 [P] [US7] Create IntegrationConfigMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/IntegrationConfigMapper.java
- [ ] T133 [US7] Create ExternalSystemService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/ExternalSystemService.java
- [ ] T134 [US7] Create IntegrationConfigService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/IntegrationConfigService.java
- [ ] T135 [US7] Create ExternalSystemController in continew-wms/src/main/java/top/continew/admin/wms/controller/ExternalSystemController.java
- [ ] T136 [US7] Create IntegrationConfigController in continew-wms/src/main/java/top/continew/admin/wms/controller/IntegrationConfigController.java
- [ ] T137 [US7] Implement ExternalSystemMapper.xml in continew-wms/src/main/resources/mapper/ExternalSystemMapper.xml
- [ ] T138 [US7] Implement IntegrationConfigMapper.xml in continew-wms/src/main/resources/mapper/IntegrationConfigMapper.xml
- [ ] T139 [US7] Add REST API endpoints for external system integration
- [ ] T140 [US7] Add data synchronization mechanisms with external systems
- [ ] T141 [US7] Add order processing from external systems
- [ ] T142 [US7] Add inventory data synchronization to external systems

**Checkpoint**: At this point, User Stories 1, 2, 3, 4, 5, 6 AND 7 should all work independently

---

## Phase 10: User Story 8 - 报表分析 (Priority: P3)

**Goal**: Implement reports and analytics for inventory levels, movement patterns, and operational efficiency

**Independent Test**: Can be fully tested by generating reports and verifying that data is accurate and presented in a useful format.

### Implementation for User Story 8

- [ ] T143 [P] [US8] Create ReportConfig entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/ReportConfig.java
- [ ] T144 [P] [US8] Create InventoryReportResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/InventoryReportResp.java
- [ ] T145 [P] [US8] Create TurnoverReportResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/TurnoverReportResp.java
- [ ] T146 [P] [US8] Create OperationReportResp DTO in continew-wms/src/main/java/top/continew/admin/wms/model/resp/OperationReportResp.java
- [ ] T147 [P] [US8] Create ReportQuery DTO in continew-wms/src/main/java/top/continew/admin/wms/model/query/ReportQuery.java
- [ ] T148 [P] [US8] Create ReportConfigMapper interface in continew-wms/src/main/java/top/continew/admin/wms/mapper/ReportConfigMapper.java
- [ ] T149 [US8] Create ReportService interface and implementation in continew-wms/src/main/java/top/continew/admin/wms/service/ReportService.java
- [ ] T150 [US8] Create ReportController in continew-wms/src/main/java/top/continew/admin/wms/controller/ReportController.java
- [ ] T151 [US8] Implement ReportConfigMapper.xml in continew-wms/src/main/resources/mapper/ReportConfigMapper.xml
- [ ] T152 [US8] Add inventory report generation functionality
- [ ] T153 [US8] Add turnover report generation functionality
- [ ] T154 [US8] Add operation efficiency report generation functionality
- [ ] T155 [US8] Add configurable report generation
- [ ] T156 [US8] Add report export functionality using FastExcel
- [ ] T157 [US8] Integrate with all previous entities for comprehensive reporting

**Checkpoint**: All user stories should now be independently functional

---

## Phase N: Polish & Cross-Cutting Concerns

**Purpose**: Improvements that affect multiple user stories

- [X] T158 [P] Add Crane4j data filling container configurations in continew-wms/src/main/java/top/continew/admin/wms/container/
- [X] T159 [P] Add common utility classes in continew-wms/src/main/java/top/continew/admin/wms/util/
- [X] T160 [P] Add common constants in continew-wms/src/main/java/top/continew/admin/wms/constant/
- [X] T161 [P] Add enum classes for statuses and types in continew-wms/src/main/java/top/continew/admin/wms/enums/
- [X] T162 [P] Documentation updates in continew-wms/README.md
- [ ] T163 Code cleanup and refactoring across all modules
- [ ] T164 Performance optimization across all stories
- [X] T165 [P] Add unit tests in continew-wms/src/test/java/top/continew/admin/wms/
- [ ] T166 Security hardening for all endpoints
- [ ] T167 Run quickstart.md validation to ensure all functionality works as expected
- [ ] T168 Add API documentation using SpringDoc
- [ ] T169 Add comprehensive logging for all operations
- [ ] T170 Add cache configuration for frequently accessed data using Redis

---

## Dependencies & Execution Order

### Phase Dependencies

- **Setup (Phase 1)**: No dependencies - can start immediately
- **Foundational (Phase 2)**: Depends on Setup completion - BLOCKS all user stories
- **User Stories (Phase 3+)**: All depend on Foundational phase completion
  - User stories can then proceed in parallel (if staffed)
  - Or sequentially in priority order (P1 → P2 → P3)
- **Polish (Final Phase)**: Depends on all desired user stories being complete

### User Story Dependencies

- **User Story 1 (P1)**: Can start after Foundational (Phase 2) - No dependencies on other stories
- **User Story 2 (P2)**: Can start after Foundational (Phase 2) - Integrates with US1 entities
- **User Story 3 (P3)**: Can start after Foundational (Phase 2) - Integrates with US1 entities
- **User Story 4 (P2)**: Can start after Foundational (Phase 2) - Integrates with US1 entities
- **User Story 5 (P3)**: Can start after Foundational (Phase 2) - Integrates with US1, US2, US3, US4 entities
- **User Story 6 (P3)**: Can start after Foundational (Phase 2) - Integrates with all previous entities
- **User Story 7 (P4)**: Can start after Foundational (Phase 2) - Integrates with all previous entities
- **User Story 8 (P3)**: Can start after Foundational (Phase 2) - Integrates with all previous entities

### Within Each User Story

- Models before services
- Services before endpoints
- Core implementation before integration
- Story complete before moving to next priority

### Parallel Opportunities

- All Setup tasks marked [P] can run in parallel
- All Foundational tasks marked [P] can run in parallel (within Phase 2)
- Once Foundational phase completes, all user stories can start in parallel (if team capacity allows)
- Models within a story marked [P] can run in parallel
- Different user stories can be worked on in parallel by different team members

---

## Parallel Example: User Story 1

```bash
# Launch all models for User Story 1 together:
Task: "Create Item entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Item.java"
Task: "Create Location entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Location.java"
Task: "Create Supplier entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Supplier.java"
Task: "Create Customer entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Customer.java"
Task: "Create Warehouse entity in continew-wms/src/main/java/top/continew/admin/wms/model/entity/Warehouse.java"
```

---

## Implementation Strategy

### MVP First (User Story 1 Only)

1. Complete Phase 1: Setup
2. Complete Phase 2: Foundational (CRITICAL - blocks all stories)
3. Complete Phase 3: User Story 1
4. **STOP and VALIDATE**: Test User Story 1 independently
5. Deploy/demo if ready

### Incremental Delivery

1. Complete Setup + Foundational → Foundation ready
2. Add User Story 1 → Test independently → Deploy/Demo (MVP!)
3. Add User Story 2 → Test independently → Deploy/Demo
4. Add User Story 3 → Test independently → Deploy/Demo
5. Add User Story 4 → Test independently → Deploy/Demo
6. Add User Story 5 → Test independently → Deploy/Demo
7. Add User Story 6 → Test independently → Deploy/Demo
8. Add User Story 7 → Test independently → Deploy/Demo
9. Add User Story 8 → Test independently → Deploy/Demo
10. Each story adds value without breaking previous stories

### Parallel Team Strategy

With multiple developers:

1. Team completes Setup + Foundational together
2. Once Foundational is done:
   - Developer A: User Story 1
   - Developer B: User Story 2
   - Developer C: User Story 3
   - Developer D: User Story 4
3. Stories complete and integrate independently

---

## Notes

- [P] tasks = different files, no dependencies
- [Story] label maps task to specific user story for traceability
- Each user story should be independently completable and testable
- Verify tests fail before implementing
- Commit after each task or logical group
- Stop at any checkpoint to validate story independently
- Avoid: vague tasks, same file conflicts, cross-story dependencies that break independence
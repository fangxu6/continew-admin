# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

ContiNew Admin is a continuous iteration optimized front-end and back-end separated admin management system framework based on Java 17 + Spring Boot 3 + Vue 3 + Arco Design + TypeScript + Vite tech stack. The project adopts multi-tenant architecture and provides out-of-the-box admin solutions, including user management, role management, menu management, department management, file management, system configuration, log management, task scheduling, code generation, and other functional modules.

**Current Working Directory**: `/backend/continew-admin` (backend Java project)
**Project Root**: Parent directory contains both backend and frontend code

## Core Development Principles

### SOLID Principles

All code developed in this project **MUST** adhere to SOLID principles:

#### S - Single Responsibility Principle (SRP)
- Each class should have only one reason to change
- **Example**: Separate `UserService` (business logic) from `UserController` (HTTP handling) and `UserMapper` (data access)
- **Bad**: A service class that handles business logic, sends emails, and logs to database
- **Good**: `UserService` for business logic, `EmailService` for emails, separate logging infrastructure

```java
// ✅ Good - Single responsibility
public class UserService {
    public void createUser(UserReq req) {
        // Only user creation business logic
    }
}

public class UserNotificationService {
    public void sendWelcomeEmail(User user) {
        // Only email sending logic
    }
}

// ❌ Bad - Multiple responsibilities
public class UserService {
    public void createUser(UserReq req) {
        // user creation logic
        // email sending logic
        // logging logic
        // audit logic
    }
}
```

#### O - Open/Closed Principle (OCP)
- Classes should be open for extension but closed for modification
- Use interfaces, abstract classes, and dependency injection
- **Example**: Use strategy pattern for different authentication methods instead of modifying core auth logic

```java
// ✅ Good - Open for extension via interface
public interface AuthenticationStrategy {
    boolean authenticate(Credentials credentials);
}

public class PasswordAuthStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(Credentials credentials) {
        // Password authentication logic
    }
}

public class OAuthAuthStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(Credentials credentials) {
        // OAuth authentication logic
    }
}

// ❌ Bad - Requires modification for new auth types
public class AuthService {
    public boolean authenticate(String type, Credentials credentials) {
        if ("password".equals(type)) {
            // password logic
        } else if ("oauth".equals(type)) {
            // oauth logic
        }
        // Need to modify this method for each new type
    }
}
```

#### L - Liskov Substitution Principle (LSP)
- Subtypes must be substitutable for their base types
- Child classes should not break parent class contracts
- **Example**: All implementations of `BaseService` should work correctly when used as `BaseService` reference

```java
// ✅ Good - Child honors parent contract
public abstract class BaseService<T> {
    public abstract T findById(Long id);
}

public class UserService extends BaseService<User> {
    @Override
    public User findById(Long id) {
        return userMapper.selectById(id); // Returns User or null
    }
}

// ❌ Bad - Child breaks parent contract
public class BadUserService extends BaseService<User> {
    @Override
    public User findById(Long id) {
        throw new UnsupportedOperationException(); // Violates LSP!
    }
}
```

#### I - Interface Segregation Principle (ISP)
- Clients should not depend on interfaces they don't use
- Create specific, focused interfaces rather than large, general ones
- **Example**: Separate read and write operations into different interfaces

```java
// ✅ Good - Segregated interfaces
public interface UserReader {
    User findById(Long id);
    List<User> findAll();
}

public interface UserWriter {
    void save(User user);
    void delete(Long id);
}

public class UserService implements UserReader, UserWriter {
    // Implements both interfaces
}

// Read-only components only depend on UserReader
public class UserReportService {
    private final UserReader userReader;

    public UserReportService(UserReader userReader) {
        this.userReader = userReader;
    }
}

// ❌ Bad - Fat interface forces unnecessary dependencies
public interface UserOperations {
    User findById(Long id);
    List<User> findAll();
    void save(User user);
    void delete(Long id);
    void sendEmail(User user);
    void exportToExcel(List<User> users);
}
```

#### D - Dependency Inversion Principle (DIP)
- High-level modules should not depend on low-level modules; both should depend on abstractions
- Abstractions should not depend on details; details should depend on abstractions
- **Example**: Use Spring dependency injection with interfaces

```java
// ✅ Good - Depends on abstraction
public interface NotificationService {
    void send(String message, String recipient);
}

public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        // Email sending implementation
    }
}

public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        // SMS sending implementation
    }
}

@Service
public class UserService {
    private final NotificationService notificationService;

    @Autowired
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void createUser(UserReq req) {
        // Business logic
        notificationService.send("Welcome!", req.getEmail());
    }
}

// ❌ Bad - Depends on concrete implementation
@Service
public class UserService {
    private EmailNotificationService emailService = new EmailNotificationService();

    public void createUser(UserReq req) {
        emailService.send("Welcome!", req.getEmail());
        // Tightly coupled, hard to test, hard to change
    }
}
```

### Applying SOLID in This Project

1. **Use the established layering** (Controller → Service → Mapper) - each layer has single responsibility
2. **Leverage Spring's dependency injection** - constructor injection for DIP
3. **Extend base classes and interfaces** - use `BaseController`, `BaseService`, `BaseMapper` for OCP
4. **Create focused interfaces** - don't add methods to existing interfaces unless truly related
5. **Write testable code** - SOLID principles make unit testing easier

## Common Commands

### Backend (Maven)

```bash
# Navigate to backend directory
cd backend/continew-admin

# Clean and install dependencies
mvn clean install

# Compile (auto-formats code via spotless plugin)
mvn compile

# Skip tests compilation
mvn clean install -Dmaven.test.skip=true

# Package for production
mvn clean package -Dmaven.test.skip=true

# Run the application
mvn spring-boot:run

# Or run packaged JAR
java -jar continew-server/target/continew-admin-*.jar

# Code formatting (runs automatically on compile)
mvn spotless:apply

# Run with specific profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
java -jar continew-admin.jar --spring.profiles.active=prod
```

### Database Management

```bash
# Liquibase scripts location
continew-server/src/main/resources/db/changelog/

# Database initialization
# MySQL scripts: continew-server/src/main/resources/db/changelog/mysql/
# PostgreSQL scripts: continew-server/src/main/resources/db/changelog/postgresql/
```

### Viewing API Documentation

```bash
# Start the application and access:
http://localhost:8080/doc.html
# Uses NextDoc4j (modern replacement for Swagger UI)
```

## Architecture & Code Organization

### Multi-Module Maven Structure

The backend follows a layered modular architecture:

```
continew-admin (parent)
├── continew-server          # Deployment module (startup class, packaging)
├── continew-system          # System management (users, roles, depts, menus)
├── continew-common          # Common utilities, base classes, configurations
├── continew-plugin          # Plugin modules
│   ├── continew-plugin-open       # API open platform
│   ├── continew-plugin-tenant     # Multi-tenant plugin
│   ├── continew-plugin-schedule   # Task scheduling
│   └── continew-plugin-generator  # Code generator
├── continew-extension       # Extensions (e.g., schedule-server)
└── continew-wms             # WMS module (Warehouse Management)
```

### Layered Architecture Flow

**CRITICAL**: All code must follow this strict layering:

```
HTTP Request
    ↓
Controller (extends BaseController, uses @CrudRequestMapping)
    ↓
Service Interface (defines business methods)
    ↓
Service Implementation (business logic, transactions, @Transactional)
    ↓
Mapper (extends BaseMapper from MyBatis Plus)
    ↓
Entity (MyBatis Plus entity with @TableName)
    ↓
Database
```

**Rules**:
- Controllers ONLY handle HTTP concerns (validation, calling service)
- Service layer contains ALL business logic, transactions, data permissions
- Mappers handle data access only (no business logic)
- Never call Mapper directly from Controller

### CRUD Suite Pattern

The framework provides a powerful CRUD suite to auto-generate common APIs. Example:

```java
@Tag(name = "Department Management API")
@RestController
@CrudRequestMapping(
    value = "/system/dept",
    api = {Api.TREE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE, Api.EXPORT, Api.TREE_DICT}
)
public class DeptController extends BaseController<DeptService, DeptResp, DeptResp, DeptQuery, DeptReq> {
    // Auto-provides: tree list, get by id, create, update, delete, export, tree dict
}
```

**Generic Parameters**:
1. `DeptService` - Service interface
2. `DeptResp` - List response DTO
3. `DeptResp` - Detail response DTO (can be same as list or separate)
4. `DeptQuery` - Query conditions
5. `DeptReq` - Create/Update request DTO

**Available API Types**:
- `Api.PAGE` - Paginated list
- `Api.LIST` - Full list
- `Api.TREE` - Tree structure list
- `Api.GET` - Get by ID
- `Api.CREATE` - Create
- `Api.UPDATE` - Update
- `Api.DELETE` - Delete single
- `Api.BATCH_DELETE` - Batch delete
- `Api.EXPORT` - Excel export
- `Api.TREE_DICT` - Tree dict (for dropdowns)

### Model Package Structure

Each module follows this model organization:

```java
model/
├── entity/     # MyBatis Plus entities (@TableName, maps to DB tables)
├── query/      # Query condition objects (for list/search)
├── req/        # Request DTOs (for create/update)
└── resp/       # Response DTOs (for API responses)
```

### Data Filling with Crane4j

Use Crane4j to auto-fill related data, avoiding JOIN queries:

```java
@Data
@Accessors(chain = true)
public class UserResp {
    private Long id;
    private String username;

    // Auto-fill dept name by deptId
    @AssembleEnum(type = DeptEnum.class, ref = @Ref("name"))
    private String deptName;

    // Auto-fill creator nickname by createUser
    @Assemble(container = UserContainer.class, props = @Mapping(ref = "nickname"))
    private String createUserName;
}
```

### Permission Control with Sa-Token

**Backend**:
```java
// Method-level permission check
@RequiresPermissions("system:user:add")
@PostMapping
public Result<Void> add(@RequestBody UserReq req) {
    userService.add(req);
    return Result.success();
}

// Programmatic check
if (!StpUtil.hasPermission("system:user:delete")) {
    throw new NoPermissionException();
}
```

**Permission Naming Convention**:
```
Format: <module>:<resource>:<action>

Examples:
system:user:list          # View user list
system:user:add           # Add user
system:user:edit          # Edit user
system:user:delete        # Delete user
system:role:list          # View role list
```

### Caching with JetCache

```java
// Method-level cache (3600 seconds TTL)
@Cached(name = "userCache:", key = "#id", expire = 3600)
public UserResp getUserById(Long id) {
    return userMapper.selectById(id);
}

// Auto-update cache on modification
@CacheUpdate(name = "userCache:", key = "#req.id", value = "#result")
public UserResp updateUser(UserReq req) {
    // update logic
}

// Invalidate cache on deletion
@CacheInvalidate(name = "userCache:", key = "#id")
public void deleteUser(Long id) {
    userMapper.deleteById(id);
}
```

### Database Entity Conventions

All entities should follow this pattern:

```java
@Data
@TableName("sys_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    // Audit fields (auto-filled by MyBatis Plus)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    // Logical delete (0=not deleted, 1=deleted)
    @TableLogic
    private Integer deleted;
}
```

**Standard Fields** (recommended for all tables):
- `id` (BIGINT, auto-increment primary key)
- `create_time` (DATETIME, creation time)
- `update_time` (DATETIME, update time)
- `create_user` (BIGINT, creator user ID)
- `update_user` (BIGINT, last updater user ID)
- `deleted` (TINYINT, logical delete flag)

**Naming Conventions**:
- Table names: lowercase with underscores, prefixed (e.g., `sys_user`, `wms_warehouse`)
- Column names: lowercase with underscores (e.g., `user_name`, `is_enabled`)
- Boolean fields: `is_*` or `has_*` prefix
- Time fields: `*_time`, `*_at`, or `*_date` suffix

## Code Generation

The project includes a powerful code generator:

1. Design your database table following the naming conventions
2. Access code generator in admin UI: System Tools → Code Generator
3. Configure table mapping, field types, validation rules
4. Preview generated code
5. Generate and download both frontend and backend code

Generated code includes:
- Entity, Mapper, Service, Controller (backend)
- API definitions, list/detail pages, forms (frontend)
- CRUD operations, permission controls, validation rules
- API documentation annotations

## Key Technologies

### Backend Core
- **Spring Boot**: 3.3.12 (requires Java 17+)
- **ContiNew Starter**: 2.15.0 (pre-configured starters for common tasks)
- **MyBatis Plus**: 3.5.12 (enhanced MyBatis with CRUD generation)
- **Sa-Token**: 1.44.0 (authentication & authorization)
- **Redisson**: 3.49.0 (distributed Redis client)
- **JetCache**: 2.7.8 (method-level caching with annotations)
- **Crane4j**: 2.9.0 (field auto-filling, reduces JOIN queries)
- **NextDoc4j**: 1.1.5 (modern API documentation UI)
- **Liquibase**: 4.27.0 (database version control)
- **Hutool**: 5.8.38 (Java utility library)

### Data & Storage
- **MySQL**: 8.0+ (primary database)
- **Redis**: 7.2+ (caching & session storage)
- **HikariCP**: Default connection pool (fastest JDBC pool)
- **P6Spy**: SQL performance monitoring (dev mode)

### Additional Components
- **Fast Excel**: 1.2.0 (high-performance Excel import/export)
- **X File Storage**: 2.2.1 (unified file storage abstraction)
- **SMS4J**: 3.3.4 (SMS integration)
- **Just Auth**: 1.16.7 (third-party login integration)
- **Snail Job**: 1.5.0 (distributed task scheduling)
- **AJ-Captcha**: 1.3.0 (slider/click captcha)

## Configuration

### Environment Variables

Configure via environment variables or modify `application-{profile}.yml`:

**Database**:
- `DB_HOST`, `DB_PORT`, `DB_USER`, `DB_PWD`, `DB_NAME`

**Redis**:
- `REDIS_HOST`, `REDIS_PORT`, `REDIS_PWD`, `REDIS_DB`

### Configuration Files

```
continew-server/src/main/resources/config/
├── application.yml           # Common config
├── application-dev.yml       # Development config
└── application-prod.yml      # Production config
```

## Development Workflow

### Adding a New Module

1. **Create module directory** following existing structure
2. **Add to parent pom.xml** `<modules>` section
3. **Create module pom.xml** with appropriate dependencies
4. **Follow package structure**:
   ```
   src/main/java/top/continew/admin/{module}/
   ├── controller/     # REST controllers
   ├── service/        # Business interfaces
   │   └── impl/       # Service implementations
   ├── mapper/         # MyBatis mappers
   ├── model/          # Data models
   │   ├── entity/
   │   ├── query/
   │   ├── req/
   │   └── resp/
   ├── enums/          # Enumerations
   ├── constant/       # Constants
   └── config/         # Module-specific configs
   ```

### Adding a New Feature

1. **Design database table** following conventions (see `continew_admin_表设计规范文档.md`)
2. **Create Liquibase migration** in `db/changelog/mysql/`
3. **Generate code** using code generator OR manually create:
   - Entity class with MyBatis Plus annotations
   - Mapper interface extending `BaseMapper`
   - Service interface and implementation
   - Request/Response DTOs
   - Query conditions class
   - Controller extending `BaseController`
4. **Add permissions** to menu management
5. **Test** the CRUD operations

### Code Style

- **Follows Alibaba Java Coding Guidelines** strictly
- **Auto-formatting**: Code is auto-formatted on `mvn compile` via spotless plugin
- **Lombok Configuration**: Global config in `lombok.config`
  - Automatically applies `@EqualsAndHashCode(callSuper = true)` in inheritance
  - Disables certain annotations like `@Val`, `@Log4j` to prevent misuse
- **Comments**: High comment coverage (>45%), all public APIs documented
- **License Headers**: Auto-added by spotless plugin from `.style/license-header`

**Important**: After making code changes:
1. Close all code editor windows
2. Run `mvn compile` to auto-format
3. DO NOT reopen files to avoid IDE formatting conflicts

## Testing

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=UserServiceTest

# Skip tests during build
mvn clean package -Dmaven.test.skip=true
```

## Docker Deployment

```bash
# Build Docker image
docker build -t continew-admin:latest .

# Run with Docker Compose
cd docker
docker-compose up -d

# View logs
docker-compose logs -f continew-admin
```

## Troubleshooting

### Common Issues

1. **Port 8080 already in use**: Change `server.port` in `application.yml`
2. **Database connection failed**: Check `DB_*` environment variables or `application-dev.yml`
3. **Redis connection failed**: Ensure Redis is running and check `REDIS_*` configs
4. **Code formatting issues**: Run `mvn compile` to auto-format

### Debug Mode

```bash
# Enable debug logging
java -jar continew-admin.jar --logging.level.top.continew.admin=DEBUG

# Or set in application.yml
logging:
  level:
    top.continew.admin: DEBUG
```

### SQL Monitoring

P6Spy is enabled in dev mode. Check console output for:
- Actual executed SQL (with parameters filled in)
- Execution time
- Connection pool stats

## WMS Module (New Feature Module)

The WMS (Warehouse Management System) module is a new business module following the same architecture:

**Location**: `continew-wms/`

**Core Entities**:
- Warehouse (仓库)
- Location (库位)
- Item (物品)
- Supplier (供应商)
- Customer (客户)

**Features**:
- Basic data management
- Inbound/outbound operations
- Inventory management
- Warehouse operations
- Reports and analytics

**Integration**: The WMS module integrates seamlessly with the main system, sharing common configurations, authentication, and utilities.

## Project Characteristics

### Long-term Stability
- Created Dec 2022, v1.0.0 released Mar 2023
- Regular updates and active maintenance
- 25+ versions of ContiNew Admin, 43+ versions of ContiNew Starter

### High Code Quality
- Integrated with Sonar, Codacy for continuous quality scanning
- Comment coverage >45%
- 100% API parameter examples
- Regular CVE vulnerability scanning

### Enterprise-Ready Features
- Multi-tenant architecture (SaaS mode)
- RBAC permission control with data permissions
- Comprehensive business solutions (users, roles, orgs, system logs, notifications, etc.)
- Security: field encryption, JSON masking, XSS filtering

### Developer Experience
- CRUD suite reduces boilerplate (80-95% code auto-generated)
- ContiNew Starter components (published to Maven Central)
- Crane4j for data filling (reduces JOINs)
- JetCache for method-level caching
- P6Spy for SQL performance analysis
- TLog for request log tracing

## Important Notes

- This project requires **Java 17+** (Spring Boot 3.x requirement)
- Database migrations are managed by **Liquibase** (never modify DB directly in production)
- All business logic MUST be in Service layer, never in Controller or Mapper
- Use CRUD suite wherever possible to maintain consistency
- Follow the established patterns when adding new features
- Run `mvn compile` before committing to ensure code formatting

## Resources

- **Online Documentation**: https://continew.top
- **Demo**: Check online docs for demo links
- **API Documentation**: http://localhost:8080/doc.html (when running locally)
- **GitHub Issues**: Report bugs and feature requests on GitHub

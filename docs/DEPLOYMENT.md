# 部署说明

本文档用于在 Windows、Linux 或 macOS 上完成本地开发与单机部署。命令以项目根目录为基准。

## 1. 准备运行环境

确认以下命令可用：

```bash
java -version
mvn -version
node -v
npm -v
mysql --version
```

Java 版本应为 8，Node.js 建议使用 18 LTS。MySQL 使用 5.7 或 8.0，并确保字符集支持 `utf8mb4`。

## 2. 创建数据库

先创建独立数据库和应用账号，再导入脚本。下面的 SQL 仅作示例，生产环境请使用随机密码并通过密码管理工具保存：

```sql
CREATE DATABASE springbootgslq
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

CREATE USER 'basketball_app'@'localhost' IDENTIFIED BY 'replace-with-a-strong-password';
GRANT ALL PRIVILEGES ON springbootgslq.* TO 'basketball_app'@'localhost';
FLUSH PRIVILEGES;
```

导入数据库脚本：

```bash
mysql -u basketball_app -p springbootgslq < backend/db/springbootgslq.sql
```

`springbootgslq.sql` 提供系统表结构，`seed-demo.sql` 提供可选的篮球训练营演示数据。部署到真实环境前，请使用独立数据源并清理演示账号、预约记录、论坛内容和上传资源。

导入演示数据后，管理后台可使用 `admin / ChangeMe123!` 进行本地登录验证；该凭证不适用于生产环境。

## 3. 配置并启动后端

后端配置文件为 `backend/src/main/resources/application.yml`。数据库连接采用环境变量：

| 变量 | 默认值 | 说明 |
| --- | --- | --- |
| `DB_HOST` | `127.0.0.1` | MySQL 主机 |
| `DB_PORT` | `3306` | MySQL 端口 |
| `DB_NAME` | `springbootgslq` | 数据库名 |
| `DB_USERNAME` | `root` | 本地开发账号 |
| `DB_PASSWORD` | 空 | 数据库密码 |
| `DASHSCOPE_API_KEY` | 空 | AI 对话功能的可选凭证 |

PowerShell：

```powershell
$env:DB_HOST = "127.0.0.1"
$env:DB_PORT = "3306"
$env:DB_NAME = "springbootgslq"
$env:DB_USERNAME = "basketball_app"
$env:DB_PASSWORD = "replace-with-a-strong-password"
mvn -f backend/pom.xml spring-boot:run
```

Bash：

```bash
export DB_HOST=127.0.0.1
export DB_PORT=3306
export DB_NAME=springbootgslq
export DB_USERNAME=basketball_app
export DB_PASSWORD='replace-with-a-strong-password'
mvn -f backend/pom.xml spring-boot:run
```

服务启动后，后端上下文路径为 `/springbootgslq`。文件上传目录默认位于 `backend/src/main/resources/static/upload/`，生产环境建议将其迁移到独立持久化目录或对象存储，并配置备份策略。

## 4. 启动用户前台

```bash
cd frontend
npm install
copy .env.example .env.development   # Windows
# cp .env.example .env.development   # macOS/Linux
npm run dev
```

前台默认监听 `8888`。开发环境代理将 `/dev-api/*` 转发到后端服务，并自动去除 `/dev-api/` 前缀。

## 5. 启动管理后台

另开终端：

```bash
cd admin
npm install
copy .env.example .env.development   # Windows
# cp .env.example .env.development   # macOS/Linux
npm run dev
```

管理后台默认监听 `8889`，避免与用户前台端口冲突。

## 6. 生产构建

```bash
cd frontend
npm ci
npm run build

cd ../admin
npm ci
npm run build

cd ../backend
mvn clean package
```

前台和后台构建产物分别位于各自的 `dist/` 目录，后端构建产物位于 `backend/target/`。生产环境建议使用 Nginx 或同类网关统一提供 HTTPS、静态资源和 `/prod-api/` 反向代理，并将 `VITE_APP_SERVICE_URL` 设置为实际公开访问路径。

## 7. 发布前验收

```bash
git diff --check
cd frontend && npm run type-check && npm run build
cd ../admin && npm run type-check && npm run build
cd ../backend && mvn -DskipTests package
```

随后至少验证：用户登录、后台登录、训练营列表、预约提交、后台预约查询、文件上传和论坛读写。涉及百度地图或 AI 对话时，再分别验证对应凭证和接口额度。

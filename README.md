# 篮球训练营管理系统

一个面向篮球训练营运营场景的前后端分离管理系统，提供训练营展示、训练项目、训练人员、预约、比赛场地、器材、论坛和系统公告等业务能力，同时配套用户前台与运营管理后台。

## 项目组成

```text
篮球训练营/
├─ frontend/     # Vue 3 + TypeScript 用户前台
├─ admin/        # Vue 3 + TypeScript 运营管理后台
├─ backend/      # Java 8 + Spring Boot + MyBatis 后端
├─ docs/         # 部署、配置与维护文档
└─ README.md
```

## 功能模块

- 用户前台：训练营浏览、训练项目查看、报名预约、比赛信息、论坛互动、个人中心。
- 运营后台：用户与训练人员管理、训练营与训练项目管理、预约审核、比赛场地管理、器材管理、公告管理、论坛管理、文件上传与基础配置。
- 后端服务：REST API、Token 鉴权、MyBatis/MyBatis-Plus 数据访问、WebSocket 消息能力、静态资源与文件上传。
- 可选能力：百度地图逆地理编码、DashScope/Qwen 对话能力。第三方凭证均通过运行时配置注入。

## 技术栈

| 层次 | 技术 |
| --- | --- |
| 用户前台 | Vue 3、TypeScript、Vite、Element Plus、Pinia、Axios、ECharts |
| 管理后台 | Vue 3、TypeScript、Vite、Element Plus、Pinia、Axios、ECharts |
| 服务端 | Java 8、Spring Boot 2.2.2、MyBatis、MyBatis-Plus、Shiro、WebSocket |
| 数据库 | MySQL 5.7/8.0、UTF-8MB4 |

## 环境要求

- JDK 8
- Maven 3.6 或更高版本
- Node.js 18 LTS，npm 9 或更高版本
- MySQL 5.7 或 8.0

## 快速启动

详细部署说明见 [`docs/DEPLOYMENT.md`](docs/DEPLOYMENT.md)。最短启动路径如下：

1. 创建数据库 `springbootgslq`，导入 [`backend/db/springbootgslq.sql`](backend/db/springbootgslq.sql)；本地演示数据另行导入 [`backend/db/seed-demo.sql`](backend/db/seed-demo.sql)。
2. 设置后端环境变量 `DB_HOST`、`DB_PORT`、`DB_NAME`、`DB_USERNAME`、`DB_PASSWORD`。
3. 在 `backend/` 执行 `mvn spring-boot:run`，服务默认监听 `8080`，上下文路径为 `/springbootgslq`。
4. 在 `frontend/` 执行 `npm install` 和 `npm run dev`，前台默认地址为 `http://localhost:8888`。
5. 在 `admin/` 执行 `npm install` 和 `npm run dev`，后台默认地址为 `http://localhost:8889`。

导入 `seed-demo.sql` 后，管理后台演示账号为 `admin / ChangeMe123!`。该账号只用于本地演示，部署到真实环境前请替换账号和密码。

前台和后台的 API 代理都通过 `.env.development` 配置；复制 `.env.example` 可获得可提交到仓库的配置模板。生产环境请使用 `.env.production` 或部署平台的环境变量，不要把数据库密码、地图密钥或 AI 密钥写入源码。

## 服务地址

| 服务 | 默认地址 |
| --- | --- |
| 后端 API | `http://127.0.0.1:8080/springbootgslq` |
| 用户前台 | `http://127.0.0.1:8888` |
| 管理后台 | `http://127.0.0.1:8889` |

## 开发与构建

```bash
# 前台
cd frontend
npm install
npm run type-check
npm run build

# 管理后台
cd ../admin
npm install
npm run type-check
npm run build

# 后端
cd ../backend
mvn clean package
```

## 开源发布前检查

- 使用新的 GitHub 仓库和新的数据库实例，不复用生产数据库。
- 发布前轮换任何曾经出现在历史提交、截图、日志或配置中的凭证。
- 为生产环境设置独立的数据库账号，避免使用 `root`。
- 通过 `git diff --check`、敏感信息扫描和三端构建检查后再推送。
- 项目当前采用已有源码和数据库结构；若用于真实运营，需进一步完成权限分级、密码哈希升级、上传文件隔离和生产反向代理配置。

## 许可证

许可证类型由项目维护者在首次公开发布前确定，并在仓库根目录补充对应的 `LICENSE` 文件。

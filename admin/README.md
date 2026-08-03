# 运营管理后台

篮球训练营管理系统的运营端，基于 Vue 3、TypeScript、Vite、Element Plus、Pinia、Axios 和 ECharts 构建。

## 本地运行

```bash
npm install
copy .env.example .env.development   # Windows
# cp .env.example .env.development   # macOS/Linux
npm run dev
```

默认端口为 `8889`，与用户前台的 `8888` 端口分离。`VITE_APP_SERVICE_URL` 指向后端服务地址，`VITE_APP_BASE_API` 为开发代理前缀。完整的数据库、后端和前后台联调步骤见根目录 [`README.md`](../README.md) 与 [`docs/DEPLOYMENT.md`](../docs/DEPLOYMENT.md)。

## 校验与构建

```bash
npm run type-check
npm run build
```

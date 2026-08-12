# 018 篮球训练营管理系统 / Basketball Camp Management System

> 用用户端、管理后台和 Java 后端统一处理训练营、人员、预约、比赛、论坛和资料上传。
>
> **English:** A multi-role training-camp system for camps, people, bookings, matches, forums, and file uploads.

## 解决什么问题 / Problem

训练营报名、课程安排、人员信息和比赛内容分散在表格或聊天工具中，运营协同困难。

**English:** Camp registration, schedules, people, and match content are often scattered across spreadsheets and chats.

## 项目展示 / Demo

~~~mermaid
flowchart LR
 A[Vue 用户端] --> C[Spring Boot API]
 B[Vue 管理后台] --> C
 C --> D[MySQL]
 C --> E[训练 / 预约 / 比赛 / 论坛]
~~~

用户和管理员围绕同一套训练营业务数据协同工作。

**English:** Users and administrators work on the same training-camp data model.

## 高光亮点 / Highlights

- Vue 用户端 + Vue 管理后台。
  **English:** Vue customer surface and Vue admin console.
- Spring Boot/MyBatis Java 后端。
  **English:** Spring Boot/MyBatis Java backend.
- MySQL 脚本和文件上传。
  **English:** MySQL scripts and file upload.
- 训练营、人员、预约、比赛和论坛模块。
  **English:** Camp, people, bookings, matches, and forum modules.

## 技术名词 / Tech

`Vue · Java 8 · Spring Boot · MyBatis · MySQL`

## 从 ZIP 开始复现 / Reproduce from ZIP

1. 解压 ZIP，准备 JDK、Maven、Node.js 和 MySQL。
2. 导入数据库脚本，复制示例配置并填写本地连接。
3. 在后端执行 `mvn spring-boot:run`。
4. 分别启动用户端和管理后台，使用测试账号验证训练和预约流程。

**Expected result:** 完成上述步骤后，应能看到项目的页面、窗口、设备输出或测试结果。

**Expected result:** After these steps, you should see the project's page, window, device output, or test result.

## 范围与安全 / Scope and Safety

数据库连接、文件存储和账号需使用本地测试配置；上传功能不要接入未经授权的生产资料。

**English:** Use local test configuration for database, storage, and accounts; do not connect uploads to unauthorized production materials.

## 交流 / Contact

欢迎交流技术。

Open to technical exchange.

[English full version](README.en.md)

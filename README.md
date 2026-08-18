# 简易支付系统（安全防御 Demo）

> 一个展示 Web 安全防御能力的 Spring Boot 实战项目。

## 🚀 核心技术栈
- Java 17 / Spring Boot 4.x
- MyBatis + MySQL
- Spring Security (BCrypt 加密)
- Maven

## 🔐 项目亮点
- **SQL注入防御**：利用 MyBatis 的 `#{}` 预编译机制，彻底杜绝 SQL 拼接风险。
- **XSS攻击防御**：自定义 Filter 过滤器，对所有输入参数进行 HTML 实体转义。
- **密码加密**：使用 BCrypt 强哈希算法，加盐处理，确保用户密码即使泄露也无法破解。

## 📦 快速启动
1. 创建 MySQL 数据库：`payment_db`
2. 修改 `application.properties` 中的数据库密码
3. 启动 `PaymentSystemApplication.java`
4. 使用 Postman 访问接口

## 📝 接口文档
- `POST /user/register` 注册
- `POST /user/login` 登录
- `POST /order/create` 下单
- `GET /order/list` 查订单

## 👤 关于我
[你的名字] | [你的学校/专业] | [你的 GitHub 主页链接]
# WarmaSurvey
## 部署环境
#### 1. Java 8/11
#### 2. MySQL 5.7+

# 可以修改的地方
## 1. 数据库配置
### 方式1：
修改源码`src/main/resources/application.yml`文件中的数据库配置
### 方式2：
在项目打包后，和jar包同级目录config文件夹内拷贝`application.yml`文件，修改数据库配置

## 2. Webhook地址
### 修改方式：
修改源码`src/main/resources/templates/index.html`文件中的 251行`webhookUrl`变量
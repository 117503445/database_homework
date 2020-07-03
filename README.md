# database_homework

XDU 数据库 实验 学生成绩管理系统 后端

> 特别鸣谢 宇恺同学给予的前端技术支持 🙏

## 技术栈

Spring Boot + hibernate

## 线上地址

首页 <http://dbhomework.backend.117503445.top>

Swagger 文档 <http://dbhomework.backend.117503445.top/swagger-ui.html>

## 部署

```sh
docker run --name databasehomework -d -e dburl="jdbc:mysql://{dbhost}:{dbport}/{dbname}" -e dbun="{username}" -e dbpd="{password}" -p 80:80 --restart=always 117503445/databasehomework:latest
```

替换 {} 中的内容,主要是和数据库有关的配置.

## 本地运行

创建 application.yml , 文件内容及路径同 application.yml.example, 替换 {} 中的内容.

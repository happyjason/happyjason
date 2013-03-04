维迪易优统一通信平台

========================================================================================================

这是一个多模块的Maven项目，如果你正在阅读本文，请确保你有一定的Java基础，并且熟悉Maven的基本特性与管理技巧。 

本平台以appfuse为范例框架， Spring 为核心框架，Hibernate作为持久层的预定义模型，Spring MVC 作为基本Web框架。

模块简述：

unified-communication ------- core ---------------- 公用类与核心组件
                      |
                       ------ support-cas  -------- OAuth,SSO等鉴权登录组件
                      |
                       ------ support-vidyo ------- Vidyo与相关接口
                      |
                       ------ extension-hr -------- 公司人事管理与招聘
                      |
                       ------ extension-rcp ------- 远程逻辑服务器调用与处理
                      |
                       ------ webapp -------------- WEB表现层


部署本项目,请完成以下步骤开始:

1. 下载并安装 MySQL 5.x 数据库，建立数据库communication，默认用户名与密码请从pom文件查询。

2. 命令行模式下进入各组件目录或在含有Maven插件的Eclipse工具运行命令："mvn install"。

3. 命令行模式下进入webapp目录或在含有Maven插件的Eclipse工具运行命令："mvn jetty:run"。

4. 打开浏览器查看平台页面 http://localhost:8080。

5. 使用默认管理员 hotmob:121212，普通用户 mupeng:121212 登陆平台。

6. 更多问题请查询公司wiki：

    http://wiki.seekoom.com


维迪易优统一通信平台
==============================================================================================
本平台是一个多模块的Maven项目，除核心模块外，每个模块相对独立，可以集成其他项目。核心组件以appfuse为范例框架， Spring 为核心框架，Hibernate作为持久层的预定义模型，Spring MVC 作为基本Web框架进行开发。
 
 如果你正在阅读本文，请确保你有一定的Java基础，并且熟悉Maven的基本特性与管理技巧。

----------------------------------------------------------------------------------------------
维迪易优统一通信平台模块简述
----------------------------------------------------------------------------------------------
unified-communication-core                 核心与公用类模块。
unified-communication-support-cas          OAuth,SSO等鉴权登录组件。
unified-communication-support-vidyo        Vidyo与相关接口。
unified-communication-extension-hr         公司人事管理与招聘。
unified-communication-extension-rcp        远程逻辑服务器调用与处理。
unified-communication-extension-security   用户安全中心。
unified-communication-extension-social     社交网络整合与逻辑处理。
unified-communication-webapp               WEB表现层。
unified-communication-webapp-cms           CMS管理后台WEB表现层。

----------------------------------------------------------------------------------------------
维迪易优统一通信平台部署步骤
----------------------------------------------------------------------------------------------
1. 下载并安装 MySQL 5.x 数据库，建立数据库communication，默认用户名与密码请从pom文件查询或修改。
2. 命令行模式下进入各组件目录或在含有Maven插件的Eclipse工具运行命令："mvn install"。
3. 命令行模式下进入webapp目录或在含有Maven插件的Eclipse工具运行命令："mvn jetty:run"。
4. 打开浏览器查看平台页面 http://localhost:8080。
5. 使用默认管理员 hotmob:121212，普通用户 mupeng:121212 登陆平台。
6. 更多问题请查询公司wiki：http://wiki.seekoom.com

----------------------------------------------------------------------------------------------
维迪易优统一通信平台注意事项
----------------------------------------------------------------------------------------------
1. 字符集编码统一使用UTF-8。
2. 程序中杜绝使用可变的静态变量。
3. 包名、类名、方法名、参数名、变量名与jsp页面等命名规则参见公司Wiki。
4. 配置Log4j日志记录，不要造成多个模块同时对同一个日志文件进行写操作。
5. 尽量少将数据存入session中，避免频繁的在集群服务器间复制影响性能。
6. 不要使用与服务器本地环境相关的状态，如本地时间、操作系统状态等。
7. 用到缓存时，选取缓存一定要支持集群，或有相应及类似解决方案提供。
8. 用到附件上传，一定要将附件信息存储到指定一台附件管理的服务器上。

----------------------------------------------------------------------------------------------
Appfuse 常用的命令介绍：
----------------------------------------------------------------------------------------------
mvn appfuse:gen-model    根据数据库的表生成java类
mvn appfuse:gen          根据 POJOs.生成并安装 Tests, DAOs, Managers, Controllers and Views
mvn appfuse:full-source  把运行所需要的org.appfuse中的依赖类转换成你的包名称
mvn eclipse:eclipse      生成eclipse的项目的配置文件，用户可以直接把项目导入到eclipse中
mvn jetty:run-war        打包并且发布你的应用程序到Jetty, 查看在 http://localhost:8080
mvn appfuse:install      把生成的源代码及配置文件写入到src中
mvn integration-test     启动TOMCAT(或别的服务器)进行测试
mvn appfuse:remove       删除appfuse:gen.生成的代码
mvn appfuse:clean        清除target下的所有内容
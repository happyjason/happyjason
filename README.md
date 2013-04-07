# 维迪易优统一通信平台
---
本平台是一个可以用于建立企业解决方案的商业网络平台，使用的开源框架与技术包含liferay，appfuse，Spring，Hibernate，AJAX，Apache ServiceMix，ehcache，Groovy，ICEfaces，jBPM，JGroups，Lucene，MuleSource ESB，Seam，Tapestry，Velocity等.如果你正在阅读本文，请确保你有一定的Java基础，熟悉Maven的特性,并且详细阅读过或者掌握liferay开发的技巧。

## 模块
<pre style="border:0px;">unified-communication-core                 核心与公用类模块
unified-communication-extension-hr         公司人事管理与招聘
unified-communication-extension-rcp        远程逻辑服务器调用与处理
unified-communication-extension-security   用户安全中心
unified-communication-extension-social     社交网络整合与逻辑处理
unified-communication-support-cas          OAuth,SSO等鉴权登录组件
unified-communication-support-vidyo        与Vidyo相关接口
unified-communication-support-unicom       与China Unicom相关接口
unified-communication-support-liferay      liferay portlet扩展
unified-communication-webapp               WEB表现层</pre>

## 注意
1. 字符集编码统一使用UTF-8。
2. 程序中杜绝使用可变的静态变量。
3. 包名、类名、方法名、参数名、变量名与jsp页面等命名规则参见公司Wiki。
4. 配置Log4j日志记录，不要造成多个模块同时对同一个日志文件进行写操作。
5. 尽量少将数据存入session中，避免频繁的在集群服务器间复制影响性能。
6. 不要使用与服务器本地环境相关的状态，如本地时间、操作系统状态等。
7. 用到缓存时，选取缓存一定要支持集群，或有相应及类似解决方案提供。
8. 用到附件上传，一定要将附件信息存储到指定一台附件管理的服务器上。

## 部署
1. 下载并安装 MySQL 5.x 数据库，建立数据库communication，默认用户名与密码请从pom文件查询或修改。
2. 进入unified-communication-extension-liferay中的liferay-dist目录由命令行模式或含有Maven插件的Eclipse工具运行："mvn install"。
3. support,extension等项目由命令行模式或含有Maven插件的Eclipse工具运行："mvn install"。
4. portlet等项目由命令行模式或含有Maven插件的Eclipse工具运行："mvn package",然后运行"mvn liferay:deploy"。
5. 命令行模式下进入webapp目录或在含有Maven插件的Eclipse工具运行命令："mvn jetty:run"。
6. 打开浏览器查看平台页面 http://localhost:8080。
7. 使用默认管理员 hotmob:121212，普通用户 mupeng:121212 登陆平台。
8. 更多问题请查询公司wiki：http://wiki.seekoom.com

## Maven
> <pre style="border:0px;">mvn appfuse:gen-model     根据数据库的表生成java类
mvn appfuse:gen           根据 POJOs.生成并安装 Tests, DAOs, Managers, Controllers and Views
mvn appfuse:full-source   把运行所需要的org.appfuse中的依赖类转换成你的包名称
mvn eclipse:eclipse       生成eclipse的项目的配置文件，用户可以直接把项目导入到eclipse中
mvn jetty:run-war         打包并且发布你的应用程序到Jetty, 查看在 http://localhost:8080
mvn appfuse:install       把生成的源代码及配置文件写入到src中
mvn integration-test      启动TOMCAT(或别的服务器)进行测试
mvn appfuse:remove        删除appfuse:gen.生成的代码
mvn appfuse:clean         清除target下的所有内容</pre>
<pre style="border:0px;">mvn archetype:generate -B -DarchetypeGroupId=com.liferay.maven.archetypes -DarchetypeArtifactId=liferay-ext-archetype -DarchetypeVersion=6.1.1 -DgroupId=com.ammob.communication -DartifactId=liferay-hook-wdyy -Dpackage=foo</pre>
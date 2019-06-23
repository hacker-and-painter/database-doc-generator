# database-doc-generator 数据库文档生成器

> 原项目地址 [database-doc-generator](https://github.com/enilu/database-doc-generator)

## 1. 功能介绍

根据数据库表DDL生成markdown文档，支持Mysql、postgresql等数据库

## 2. 快速使用

使用idea打开，运行Main.java

输入完成后回车，即可生成数据库文档目录${dbname}-doc,目录中文档以markdown文件为载体：

![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190607194723.png)

### 2.1 使用MySQL数据库生成文档示例

```bash
1:MySQL
2:Oracle
3:PostgreSQL
4:SQLServer
Select the appropriate numbers choose database type
(Enter 'c' to cancel):
 1
input database name:
guns-lite
input host:
localhost
input port(default 3306):

input username(default root):

input password:
root

```

![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190615022129.png)

### 2.2 使用PostgreSQL数据库生成文档示例

```
choose database:
1:MySQL
2:Oracle
3:PostgreSQL
4:SQLServer
Select the appropriate numbers choose database type
(Enter 'c' to cancel):
 3
input database name:
test
input host:
localhost
input port(default 5432):

input username(default postgres):

input password:
root
```

![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190615022203.png)

### 2.3 使用gitbook在线查看数据文档

确保安装了gitbook后，进入上述文件目录的命令行窗口运行：gitbook serve

```bash
Live reload server started on port: 35729
Press CTRL+C to quit ...

info: 7 plugins are installed 
info: loading plugin "livereload"... OK 
info: loading plugin "highlight"... OK 
info: loading plugin "search"... OK 
info: loading plugin "lunr"... OK 
info: loading plugin "sharing"... OK 
info: loading plugin "fontsettings"... OK 
info: loading plugin "theme-default"... OK 
info: found 3 pages 
info: found 0 asset files 
info: >> generation finished with success in 0.9s ! 

Starting server ...
Serving book on http://localhost:4000
```

访问 http://localhost:4000 ，即可在线查看数据库文档

如果遇到 You already have a server listening on 35729 错误信息，使用以下命令解决

```
sudo lsof -i :35729
kill 查到的pid即可
```

![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190607200945.png)

![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190615023510.png)

## 3. 后续计划 TODO

使用springboot对代码进行改造，写个接口传入数据参数生成数据库文档，而不是运行Main.java

# database-doc-generator 数据库文档生成器

> 原项目地址 [database-doc-generator](https://github.com/enilu/database-doc-generator)

## 快速使用


使用idea打开，运行Main.java

![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190607194723.png)

```bash
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
5432
input username(default postgres):
postgres
input password:
root

```
- 输入完成后回车，即可生成数据库文档目录${dbname}-doc,目录中文档以markdown文件为载体：

![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190607194345.png)

- 确保安装了gitbook后，进入上述文件目录的命令行窗口运行：gitbook serve

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
- 访问 http://localhost:4000，即可在线查看数据库文档

![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190607194535.png)

![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190607194600.png)


## 后续计划 TODO

使用springboot对代码进行改造，写个接口来生成数据库文档，而不是运行Main.java


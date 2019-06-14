# banner(t_cms_banner)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|bigint(20)|PRI|否||
|create_by|bigint(20)||是|创建者|
|create_time|datetime||是|创建时间/注册时间|
|modify_by|bigint(20)||是|最后更新人|
|modify_time|datetime||是|最后更新时间|
|title|varchar(255)||是||
|url|varchar(255)||是||
|type|varchar(18)||是||
|id_file|bigint(20)||是|banner文件id|

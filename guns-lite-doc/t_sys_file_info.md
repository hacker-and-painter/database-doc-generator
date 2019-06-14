# 文件信息(t_sys_file_info)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|bigint(20)|PRI|否||
|create_by|bigint(20)||是|创建人|
|create_time|datetime||是|创建时间/注册时间|
|modify_by|bigint(20)||是|最后更新人|
|modify_time|datetime||是|最后更新时间|
|original_file_name|varchar(255)||是||
|real_file_name|varchar(255)||是||

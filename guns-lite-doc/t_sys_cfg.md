# 系统参数(t_sys_cfg)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|bigint(64)|PRI|否|自增主键|
|cfg_name|varchar(100)||是|参数名|
|cfg_value|varchar(3000)||是|参数值|
|cfg_desc|varchar(200)||是|参数描述|
|create_time|datetime||是||
|create_by|bigint(20)||是||
|modify_time|datetime||是||
|modify_by|bigint(20)||是||

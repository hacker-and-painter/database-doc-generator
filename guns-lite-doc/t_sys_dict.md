# 字典表(t_sys_dict)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|int(11)|PRI|否|主键id|
|num|varchar(32)||是|排序|
|pid|int(11)||是|父级字典|
|name|varchar(255)||是|名称|
|tips|varchar(255)||是|提示|
|create_time|datetime||是||
|create_by|bigint(20)||是||
|modify_time|datetime||是||
|modify_by|bigint(20)||是||

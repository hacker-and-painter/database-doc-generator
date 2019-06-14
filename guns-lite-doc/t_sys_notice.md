# 通知表(t_sys_notice)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|int(11)|PRI|否|主键|
|title|varchar(255)||是|标题|
|type|int(11)||是|类型|
|content|text||是|内容|
|create_time|datetime||是|创建时间|
|create_by|bigint(11)||是|创建人|
|modify_time|datetime||是||
|modify_by|bigint(20)||是||

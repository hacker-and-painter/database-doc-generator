# 操作日志(t_sys_operation_log)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|int(65)|PRI|否|主键|
|logtype|varchar(255)||是|日志类型|
|logname|varchar(255)||是|日志名称|
|userid|int(65)||是|用户id|
|classname|varchar(255)||是|类名称|
|method|text||是|方法名称|
|create_time|datetime||是|创建时间|
|succeed|varchar(255)||是|是否成功|
|message|text||是|备注|

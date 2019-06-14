# 登录记录(t_sys_login_log)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|int(65)|PRI|否|主键|
|logname|varchar(255)||是|日志名称|
|userid|int(65)||是|管理员id|
|create_time|datetime||是|创建时间|
|succeed|varchar(255)||是|是否执行成功|
|message|text||是|具体消息|
|ip|varchar(255)||是|登录ip|

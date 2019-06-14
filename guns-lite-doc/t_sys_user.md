# 管理员表(t_sys_user)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|int(11)|PRI|否|主键id|
|avatar|varchar(255)||是|头像|
|account|varchar(45)||是|账号|
|password|varchar(45)||是|密码|
|salt|varchar(45)||是|md5密码盐|
|name|varchar(45)||是|名字|
|birthday|datetime||是|生日|
|sex|int(11)||是|性别（1：男 2：女）|
|email|varchar(45)||是|电子邮件|
|phone|varchar(45)||是|电话|
|roleid|varchar(255)||是|角色id|
|deptid|int(11)||是|部门id|
|status|int(11)||是|状态(1：启用  2：冻结  3：删除）|
|create_time|datetime||是|创建时间|
|version|int(11)||是|保留字段|
|create_by|bigint(20)||是||
|modify_time|datetime||是||
|modify_by|bigint(20)||是||

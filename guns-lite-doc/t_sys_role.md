# 角色表(t_sys_role)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|int(11)|PRI|否|主键id|
|num|int(11)||是|序号|
|pid|int(11)||是|父角色id|
|name|varchar(255)||是|角色名称|
|deptid|int(11)||是|部门名称|
|tips|varchar(255)||是|提示|
|version|int(11)||是|保留字段(暂时没用）|
|create_time|datetime||是||
|create_by|bigint(20)||是||
|modify_time|datetime||是||
|modify_by|bigint(20)||是||

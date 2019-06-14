# 部门表(t_sys_dept)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|int(11)|PRI|否|主键id|
|num|int(11)||是|排序|
|pid|int(11)||是|父部门id|
|pids|varchar(255)||是|父级ids|
|simplename|varchar(45)||是|简称|
|fullname|varchar(255)||是|全称|
|tips|varchar(255)||是|提示|
|version|int(11)||是|版本（乐观锁保留字段）|
|create_time|datetime||是||
|create_by|bigint(20)||是||
|modify_time|datetime||是||
|modify_by|bigint(20)||是||

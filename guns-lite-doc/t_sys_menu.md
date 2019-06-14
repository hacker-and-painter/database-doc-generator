# 菜单表(t_sys_menu)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|bigint(20)|PRI|否|主键id|
|code|varchar(255)||是|菜单编号|
|pcode|varchar(255)||是|菜单父编号|
|pcodes|varchar(255)||是|当前菜单的所有父菜单编号|
|name|varchar(255)||是|菜单名称|
|icon|varchar(255)||是|菜单图标|
|url|varchar(255)||是|url地址|
|num|int(65)||是|菜单排序号|
|levels|int(65)||是|菜单层级|
|ismenu|int(11)||是|是否是菜单（1：是  0：不是）|
|tips|varchar(255)||是|备注|
|status|int(65)||是|菜单状态 :  1:启用   0:不启用|
|isopen|int(11)||是|是否打开:    1:打开   0:不打开|
|create_time|datetime||是||
|create_by|bigint(20)||是||
|modify_time|datetime||是||
|modify_by|bigint(20)||是||

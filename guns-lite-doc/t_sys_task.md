# 定时任务(t_sys_task)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|bigint(64)|PRI|否|自增主键|
|name|varchar(50)||是|任务名|
|job_group|varchar(50)||是|任务组|
|job_class|varchar(255)||是|执行类|
|note|varchar(255)||是|任务说明|
|cron|varchar(50)||是|定时规则|
|data|text||是|执行参数|
|exec_at|datetime||是|执行时间|
|exec_result|text||是|执行结果|
|disabled|tinyint(1)||是|是否禁用|
|create_time|datetime||是||
|create_by|bigint(20)||是||
|concurrent|tinyint(4)||是|是否允许并发|
|modify_time|datetime||是||
|modify_by|bigint(20)||是||

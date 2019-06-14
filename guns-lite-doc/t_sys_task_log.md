# 定时任务日志(t_sys_task_log)
| 列名   | 类型   | KEY  | 可否为空 | 注释   |
| ---- | ---- | ---- | ---- | ---- |
|id|bigint(64)|PRI|否|自增主键|
|name|varchar(50)||是|任务名|
|exec_at|datetime||是|执行时间|
|exec_success|int(11)||是|执行结果（成功:1、失败:0)|
|job_exception|varchar(255)||是|抛出异常|
|id_task|bigint(20)||是||

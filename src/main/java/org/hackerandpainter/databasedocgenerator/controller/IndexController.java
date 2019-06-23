package org.hackerandpainter.databasedocgenerator.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.hackerandpainter.databasedocgenerator.database.*;
import org.nutz.dao.impl.SimpleDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-06-07 19:16
 **/
@RestController

public class IndexController {

    @GetMapping("/generator")
    @ApiImplicitParams({ @ApiImplicitParam(name = "dbType", value = "1:MySQL\n2:Oracle\n3:PostgreSQL\n4:SQLServer", defaultValue = "3", required = true),
            @ApiImplicitParam(name = "ip", value = "ip地址", defaultValue = "localhost", required = true),
            @ApiImplicitParam(name = "databaseName", value = "数据库名", required = true),
            @ApiImplicitParam(name = "port", value = "端口", defaultValue = "5432", required = true),
            @ApiImplicitParam(name = "userName", value = "用户名", defaultValue = "postgres", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "root", required = true),
            @ApiImplicitParam(name = "serviceName", value = "Oracle数据库才需要", required = false),
    })
    public String generatorDatabaseDoc(String dbType,
                                     @RequestParam(defaultValue = "localhost") String ip,
                                     String databaseName,
                                     @RequestParam(defaultValue = "5432") String port,
                                     @RequestParam(defaultValue = "postgres") String userName,
                                     @RequestParam(defaultValue = "root") String password,
                                     @RequestParam(required = false) String serviceName) {

        if ("c".equals(dbType)) {
            System.exit(-1);
        }
        if (Integer.valueOf(dbType) < 1 || Integer.valueOf(dbType) > 4) {
            System.out.println("wrong number,will exit");
            System.exit(-1);
        }
        if ("2".equals(dbType)) {
            System.out.println("input service name:");
        }
        if ("1".equals(dbType) || "3".equals(dbType) || "4".equals(dbType)) {
            System.out.println("input database name:");
        }

        port = getDefaultPort(dbType);

        SimpleDataSource dataSource = new SimpleDataSource();
        if ("1".equals(dbType)) {
            dataSource.setJdbcUrl("jdbc:mysql://" + ip + ":" + port + "/" + databaseName);
        } else if ("2".equals(dbType)) {
            dataSource.setJdbcUrl("jdbc:oracle:thin:@" + ip + ":" + port + ":" + serviceName);
        } else if ("3".equals(dbType)) {
            dataSource.setJdbcUrl("jdbc:postgresql://" + ip + ":" + port + "/" + databaseName);
        } else if ("4".equals(dbType)) {
            dataSource.setJdbcUrl("jdbc:sqlserver://" + ip + ":" + port + ";database=" + databaseName);
        }

        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        Generator generator = null;

        switch (dbType) {
            case "1":
                generator = new MySQL(databaseName, dataSource);
                break;
            case "2":
                generator = new Oracle(userName, dataSource);
                break;
            case "3":
                generator = new PostgreSQL(databaseName, dataSource);
                break;
            case "4":
                generator = new SqlServer(databaseName, dataSource);
        }

        generator.generateDoc();

        return "文档生成成功";
    }

    private static String getDefaultPort(String dbType) {
        String defaultPort = "";

        switch (dbType) {
            case "1": {
                defaultPort = "3306";
                break;
            }
            case "2": {
                defaultPort = "1521";
                break;
            }
            case "3": {
                defaultPort = "5432";
                break;
            }
            case "4": {
                defaultPort = "1433";
                break;
            }
            default: {
                defaultPort = "-";
                break;
            }
        }

        return defaultPort;
    }


    private static String getDefaultUser(String dbType) {
        String defaultUser = "";

        switch (dbType) {
            case "1": {
                defaultUser = "root";
                break;
            }
            case "2": {
                defaultUser = "root";
                break;
            }
            case "3": {
                defaultUser = "postgres";
                break;
            }
            case "4": {
                defaultUser = "root";
                break;
            }
            default: {
                defaultUser = "root";
                break;
            }
        }

        return defaultUser;
    }
}

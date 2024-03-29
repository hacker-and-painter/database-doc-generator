package org.hackerandpainter.databasedocgenerator.database;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import org.hackerandpainter.databasedocgenerator.bean.ColumnVo;
import org.hackerandpainter.databasedocgenerator.bean.TableVo;
import org.hackerandpainter.databasedocgenerator.doc.WordGenerator;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;
import org.nutz.dao.sql.Sql;
import org.nutz.lang.Files;
import org.nutz.lang.Strings;

import java.io.File;
import java.util.List;

/**
 * Generator
 *
 * @author zt
 * @version 2019/1/6 0006
 */
public abstract class Generator {
    private static String savePath = "";
    private SimpleDataSource dataSource;
    protected Dao dao = null;
    protected String dbName;
    protected String docPath;

    public Generator(String dbName, SimpleDataSource dataSource) {
        this.dataSource = dataSource;
        dao = new NutDao(dataSource);
        this.dbName = dbName;
        this.docPath = dbName + "-doc";
    }


    public abstract List<TableVo> getTableData();

    /**
     * 获取表结构数据
     *
     * @return 返回文件存储地址
     */
    public String generateDoc() {
        String home = System.getProperty("user.home");
        savePath = home + "/" + UUID.fastUUID() + "/" + docPath;
        File docDir = new File(savePath);
        if (docDir.exists()) {
            FileUtil.clean(docDir);
        } else {
            docDir.mkdirs();
        }
        List<TableVo> list = getTableData();
        save2File(list, savePath);
        //保存word
        WordGenerator.createDoc(dbName, list, savePath);
        return savePath;

    }

    public void save2File(List<TableVo> tables, String savePath) {
        saveSummary(tables, savePath);
        saveReadme(tables, savePath);
        saveMerge(tables, savePath);
        tables.parallelStream().forEach(tableVo -> saveTableFile(tableVo, savePath));

    }

    private void saveSummary(List<TableVo> tables, String savePath) {
        StringBuilder builder = new StringBuilder("# Summary").append("\r\n").append("* [Introduction](README.md)")
                .append("\r\n");
        for (TableVo tableVo : tables) {
            String name = Strings.isEmpty(tableVo.getComment()) ? tableVo.getTable() : tableVo.getComment();
            builder.append("* [" + name + "](" + tableVo.getTable() + ".md)").append("\r\n");
        }
        try {
            Files.write(new File(savePath + File.separator + "SUMMARY.md"), builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveReadme(List<TableVo> tables, String savePath) {
        StringBuilder builder = new StringBuilder("# " + dbName + "数据库文档").append("\r\n");
        for (TableVo tableVo : tables) {
            builder.append("- [" + (Strings.isEmpty(tableVo.getComment()) ? tableVo.getTable() : tableVo.getComment())
                    + "]" +
                    "(" + tableVo
                    .getTable() + ".md)")
                    .append
                            ("\r\n");
        }
        try {
            Files.write(new File(savePath + File
                    .separator + "README.md"), builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * MERGE 合并表结构文档
     *
     * @param tables
     */
    private void saveMerge(List<TableVo> tables, String savePath) {
        StringBuffer builder = new StringBuffer("# ").append(dbName).append("数据库设计文档").append("\r\n")
                .append("\r\n");
        tables.parallelStream().forEach(tableVo -> {
            builder.append("#### " + (Strings.isBlank(tableVo.getComment()) ? tableVo.getTable() : tableVo
                    .getComment()) + "(" + tableVo.getTable() + ")").append("\r\n");
            builder.append("| 列名   | 类型   | KEY  | 可否为空 | 注释   |").append("\r\n");
            builder.append("| ---- | ---- | ---- | ---- | ---- |").append("\r\n");
            List<ColumnVo> columnVos = tableVo.getColumns();
            for (int i = 0; i < columnVos.size(); i++) {
                ColumnVo column = columnVos.get(i);
                builder.append("|").append(column.getName()).append("|").append(column.getType()).append("|").append
                        (Strings.sNull(column.getKey())).append("|").append(column.getIsNullable()).append("|").append
                        (column.getComment()).append("|\r\n");
            }
        });
        try {
            Files.write(new File(savePath + File.separator + dbName + ".md"), builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveTableFile(TableVo table, String savePath) {

        StringBuilder builder = new StringBuilder("# " + (Strings.isBlank(table.getComment()) ? table.getTable() : table
                .getComment()) + "(" + table.getTable() + ")").append("\r\n");
        builder.append("| 列名   | 类型   | KEY  | 可否为空 | 注释   |").append("\r\n");
        builder.append("| ---- | ---- | ---- | ---- | ---- |").append("\r\n");
        List<ColumnVo> columnVos = table.getColumns();
        for (int i = 0; i < columnVos.size(); i++) {
            ColumnVo column = columnVos.get(i);
            builder.append("|").append(column.getName()).append("|").append(column.getType()).append("|").append
                    (Strings.sNull(column.getKey())).append("|").append(column.getIsNullable()).append("|").append
                    (column.getComment()).append("|\r\n");
        }
        try {
            Files.write(new File(savePath + File
                    .separator + table.getTable() + ".md"), builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Record> getList(String sqlStr) {
        Sql sql = Sqls.create(sqlStr);
        sql.setCallback(Sqls.callback.records());
        dao.execute(sql);
        List<Record> list = sql.getList(Record.class);
        return list;
    }
}

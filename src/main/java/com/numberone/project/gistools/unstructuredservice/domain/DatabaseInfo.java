package com.numberone.project.gistools.unstructuredservice.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;

/**
 * @author hwx
 * @date 2022/4/1 17:18
 */
public class DatabaseInfo {

    private String name;

    private String tableName;

    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}

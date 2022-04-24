package com.numberone.project.gistools.interactive.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 字典表对象 gt_dict_type
 *
 * @author hwx
 * @date 2022-04-19
 */
public class GtDictType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** null */
    @Excel(name = "null")
    private String dictName;

    /** null */
    @Excel(name = "null")
    private String tableName;

    /** null */
    @Excel(name = "null")
    private String fieldName;

    private List<GtDictData> dictDataList;

    private String resourceId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public List<GtDictData> getDictDataList() {
        return dictDataList;
    }

    public void setDictDataList(List<GtDictData> dictDataList) {
        this.dictDataList = dictDataList;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setDictName(String dictName)
    {
        this.dictName = dictName;
    }

    public String getDictName()
    {
        return dictName;
    }
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getTableName()
    {
        return tableName;
    }
    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dictName", getDictName())
            .append("tableName", getTableName())
            .append("fieldName", getFieldName())
            .toString();
    }
}

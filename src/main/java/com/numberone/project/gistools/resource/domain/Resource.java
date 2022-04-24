package com.numberone.project.gistools.resource.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * resource对象 gt_resource
 *
 * @author wly
 * @date 2022-03-30
 */
public class Resource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** null */
    @Excel(name = "null")
    private String fileName;

    /** null */
    @Excel(name = "null")
    private String layerName;

    /** null */
    @Excel(name = "null")
    private Integer type;

    /** null */
    @Excel(name = "null", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** null */
    @Excel(name = "null")
    private String note;

    /** null */
    @Excel(name = "null")
    private String project;

    /** null */
    @Excel(name = "null")
    private String url;

    private String geometryType;

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    private String typeList;

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(String id)
    {
        this.id = id;
    }


    public String getId()
    {
        return id;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }


    public String getFileName()
    {
        return fileName;
    }

    public void setLayerName(String layerName)
    {
        this.layerName = layerName;
    }


    public String getLayerName()
    {
        return layerName;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }


    public Integer getType()
    {
        return type;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setNote(String note)
    {
        this.note = note;
    }


    public String getNote()
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("fileName", getFileName())
                .append("layerName", getLayerName())
                .append("type", getType())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("endTime", getEndTime())
                .append("note", getNote())
                .append("project", getProject())
                .append("url", getUrl())
                .toString();
    }
}

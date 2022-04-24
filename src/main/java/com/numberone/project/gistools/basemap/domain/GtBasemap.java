package com.numberone.project.gistools.basemap.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 gt_basemap
 * 
 * @author xskj
 * @date 2022-03-30
 */
public class GtBasemap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** $column.columnComment */
    @Excel(name = "项目")
    private String project;

    /** $column.columnComment */
    @Excel(name = "地图类型")
    private String mapType;

    /** $column.columnComment */
    @Excel(name = "")
    private String crs;

    /** $column.columnComment */
    @Excel(name = "${comment}")
    private String sType;

    /** $column.columnComment */
    @Excel(name = "路径")
    private String url;

    /** $column.columnComment */
    @Excel(name = "名称")
    private String name;

    /** $column.columnComment */
    @Excel(name = "参数")
    private String param;

    /** $column.columnComment */
    @Excel(name = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** $column.columnComment */
    @Excel(name = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** $column.columnComment */
    @Excel(name = "${comment}")
    private String note;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setProject(String project)
    {
        this.project = project;
    }

    public String getProject()
    {
        return project;
    }
    public void setMapType(String mapType)
    {
        this.mapType = mapType;
    }

    public String getMapType()
    {
        return mapType;
    }
    public void setCrs(String crs)
    {
        this.crs = crs;
    }

    public String getCrs()
    {
        return crs;
    }
    public void setsType(String sType)
    {
        this.sType = sType;
    }

    public String getsType()
    {
        return sType;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
    public void setParam(String param)
    {
        this.param = param;
    }

    public String getParam()
    {
        return param;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
            .append("project", getProject())
            .append("mapType", getMapType())
            .append("crs", getCrs())
            .append("sType", getsType())
            .append("url", getUrl())
            .append("param", getParam())
            .append("updateTime", getUpdateTime())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("note", getNote())
                .append("name", getName())
            .toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.numberone.project.gistools.richtext.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 富文本对象 gt_richtext
 *
 * @author hwx
 * @date 2022-03-31
 */
public class GtRichtext extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** null */
    @Excel(name = "null")
    private String name;

    /** null */
    @Excel(name = "null")
    private String content;

    /** null */
    @Excel(name = "null", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** null */
    @Excel(name = "null")
    private String note;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
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
            .append("name", getName())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("endTime", getEndTime())
            .append("note", getNote())
            .toString();
    }
}

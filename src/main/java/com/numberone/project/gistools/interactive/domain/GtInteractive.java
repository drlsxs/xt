package com.numberone.project.gistools.interactive.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;

/**
 * 数据交互配置对象 gt_interactive
 *
 * @author hwx
 * @date 2022-04-19
 */
public class GtInteractive extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** null */
    @Excel(name = "null")
    private String show;

    /** null */
    @Excel(name = "null")
    private String field;

    /** null */
    @Excel(name = "null")
    private String association;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setShow(String show)
    {
        this.show = show;
    }

    public String getShow()
    {
        return show;
    }
    public void setField(String field)
    {
        this.field = field;
    }

    public String getField()
    {
        return field;
    }
    public void setAssociation(String association)
    {
        this.association = association;
    }

    public String getAssociation()
    {
        return association;
    }
}

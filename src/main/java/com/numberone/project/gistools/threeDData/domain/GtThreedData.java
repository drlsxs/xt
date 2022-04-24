package com.numberone.project.gistools.threeDData.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;

/**
 * 三维点位数据对象 gt_3d_data
 *
 * @author hwx
 * @date 2022-04-18
 */
public class GtThreedData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** null */
    @Excel(name = "null")
    private String shapeType;

    /** null */
    @Excel(name = "null")
    private String type;

    /** null */
    @Excel(name = "null")
    private String parma;

    /** null */
    @Excel(name = "null")
    private String name;

    /** null */
    @Excel(name = "null")
    private String source;
    private String height;
    private String xoffset;
    private String yoffset;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getXoffset() {
        return xoffset;
    }

    public void setXoffset(String xoffset) {
        this.xoffset = xoffset;
    }

    public String getYoffset() {
        return yoffset;
    }

    public void setYoffset(String yoffset) {
        this.yoffset = yoffset;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setShapeType(String shapeType)
    {
        this.shapeType = shapeType;
    }

    public String getShapeType()
    {
        return shapeType;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setParma(String parma)
    {
        this.parma = parma;
    }

    public String getParma()
    {
        return parma;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }

}

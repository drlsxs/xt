package com.numberone.project.system.cjmx.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 场景模型对象 gt_3d_cjmx
 *
 * @author xskj
 * @date 2022-03-31
 */
public class Gt3dCjmx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编码 */
    private String id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 类型 */
    @Excel(name = "类型")
    private String mtype;

    /** 服务地址 */
    @Excel(name = "服务地址")
    private String url;

    /** 坐标系 */
    @Excel(name = "坐标系")
    private String crs;

    /** 生效时间 */
    @Excel(name = "生效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 失效时间 */
    @Excel(name = "失效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    private String shapeType;

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

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
    public void setMtype(String mtype)
    {
        this.mtype = mtype;
    }

    public String getMtype()
    {
        return mtype;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
    public void setCrs(String crs)
    {
        this.crs = crs;
    }

    public String getCrs()
    {
        return crs;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
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
        return "";
    }
}

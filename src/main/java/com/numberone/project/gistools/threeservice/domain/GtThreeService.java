package com.numberone.project.gistools.threeservice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;

/**
 * 三维数据服务对象 gt_three_service
 * 
 * @author wyl
 * @date 2021-10-04
 */
public class GtThreeService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** 服务名称 */
    @Excel(name = "服务名称")
    private String name;

    /** 服务描述 */
    @Excel(name = "服务描述")
    private String sdesc;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 文件夹路径 */
    @Excel(name = "文件夹路径")
    private String folderPath;

    /** 空间参考 */
    @Excel(name = "空间参考")
    private String srid;

    /** 服务url */
    private String surl;

    /** 服务参数 */
    private String sparams;

    /** 服务类型 */
    private String ftype;

    /** 状态 */
    @Excel(name = "状态")
    private String statu;

    /** 备注 */
    @Excel(name = "备注")
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
    public void setSdesc(String sdesc) 
    {
        this.sdesc = sdesc;
    }

    public String getSdesc() 
    {
        return sdesc;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setFolderPath(String folderPath) 
    {
        this.folderPath = folderPath;
    }

    public String getFolderPath() 
    {
        return folderPath;
    }
    public void setSrid(String srid) 
    {
        this.srid = srid;
    }

    public String getSrid() 
    {
        return srid;
    }
    public void setSurl(String surl) 
    {
        this.surl = surl;
    }

    public String getSurl() 
    {
        return surl;
    }
    public void setSparams(String sparams) 
    {
        this.sparams = sparams;
    }

    public String getSparams() 
    {
        return sparams;
    }
    public void setFtype(String ftype) 
    {
        this.ftype = ftype;
    }

    public String getFtype() 
    {
        return ftype;
    }
    public void setStatu(String statu) 
    {
        this.statu = statu;
    }

    public String getStatu() 
    {
        return statu;
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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sdesc", getSdesc())
            .append("filePath", getFilePath())
            .append("folderPath", getFolderPath())
            .append("srid", getSrid())
            .append("surl", getSurl())
            .append("sparams", getSparams())
            .append("ftype", getFtype())
            .append("statu", getStatu())
            .append("note", getNote())
            .toString();
    }
}

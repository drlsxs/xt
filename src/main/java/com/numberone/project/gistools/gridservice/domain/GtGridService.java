package com.numberone.project.gistools.gridservice.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;

import java.util.Date;
import java.util.Map;

/**
 * 栅格服务对象 gt_grid_service
 *
 * @author wyl
 * @date 2021-10-03
 */
@TableName("gt_grid_service")
public class GtGridService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    @TableId(type=IdType.AUTO)
    private String id;

    /** 服务名称 */
    @Excel(name = "服务名称")
    @TableField(value = "name")
    private String name;

    /** 服务描述 */
    @Excel(name = "服务描述")
    @TableField(value = "sdesc")
    private String sdesc;

    /** 文件路径 */
    @Excel(name = "文件路径")
    @TableField(value = "file_path")
    private String filePath;

    /** 文件夹路径 */
    @Excel(name = "文件夹路径")
    @TableField(value = "folder_path")
    private String folderPath;

    /** 空间参考 */
    @Excel(name = "空间参考")
    @TableField(value = "srid")
    private String srid;

    /** 服务url */
    @TableField(value = "surl")
    private String surl;

    /** 服务参数 */
    @TableField(value = "sparams")
    private String sparams;

    /** 服务类型 */
    @TableField(value = "ftype")
    private String ftype;

    /** 状态 */
    @Excel(name = "状态")
    @TableField(value = "statu")
    private String statu;

    /** 备注 */
    @Excel(name = "备注")
    @TableField(value = "note")
    private String note;

    @TableField(exist = false)
    private String searchValue;
    @TableField(exist = false)
    private String createBy;
    @TableField(exist = false)
    private Date createTime;
    @TableField(exist = false)
    private String updateBy;
    @TableField(exist = false)
    private Date updateTime;
    @TableField(exist = false)
    private String remark;
    @TableField(exist = false)
    private Map<String, Object> params;

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

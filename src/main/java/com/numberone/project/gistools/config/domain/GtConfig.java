package com.numberone.project.gistools.config.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;

/**
 * 配置对象 gt_config
 * 
 * @author wyl
 * @date 2021-10-07
 */
public class GtConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** 配置名称 */
    @Excel(name = "配置名称")
    private String name;

    /** 排序 */
    @Excel(name = "排序")
    private String sort;

    /** 地图中间件url */
    @Excel(name = "地图中间件url")
    private String msUrl;

    /** 地图中间件用户名 */
    @Excel(name = "地图中间件用户名")
    private String msUname;

    /** 地图中间件密码 */
    @Excel(name = "地图中间件密码")
    private String msPwd;

    /** 栅格资产目录 */
    @Excel(name = "栅格资产目录")
    private String gridPath;

    /** 三维资产目录 */
    @Excel(name = "三维资产目录")
    private String threePath;

    /** 栅格服务url头 */
    @Excel(name = "栅格服务url头")
    private String defUrl;

    /** 备用1 */
    private String item1;

    /** 备用2 */
    private String item2;

    /** 备用3 */
    private String item3;

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
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }
    public void setMsUrl(String msUrl) 
    {
        this.msUrl = msUrl;
    }

    public String getMsUrl() 
    {
        return msUrl;
    }
    public void setMsUname(String msUname) 
    {
        this.msUname = msUname;
    }

    public String getMsUname() 
    {
        return msUname;
    }
    public void setMsPwd(String msPwd) 
    {
        this.msPwd = msPwd;
    }

    public String getMsPwd() 
    {
        return msPwd;
    }
    public void setGridPath(String gridPath) 
    {
        this.gridPath = gridPath;
    }

    public String getGridPath() 
    {
        return gridPath;
    }
    public void setThreePath(String threePath) 
    {
        this.threePath = threePath;
    }

    public String getThreePath() 
    {
        return threePath;
    }
    public void setDefUrl(String defUrl) 
    {
        this.defUrl = defUrl;
    }

    public String getDefUrl() 
    {
        return defUrl;
    }
    public void setItem1(String item1) 
    {
        this.item1 = item1;
    }

    public String getItem1() 
    {
        return item1;
    }
    public void setItem2(String item2) 
    {
        this.item2 = item2;
    }

    public String getItem2() 
    {
        return item2;
    }
    public void setItem3(String item3) 
    {
        this.item3 = item3;
    }

    public String getItem3() 
    {
        return item3;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sort", getSort())
            .append("msUrl", getMsUrl())
            .append("msUname", getMsUname())
            .append("msPwd", getMsPwd())
            .append("gridPath", getGridPath())
            .append("threePath", getThreePath())
            .append("defUrl", getDefUrl())
            .append("item1", getItem1())
            .append("item2", getItem2())
            .append("item3", getItem3())
            .toString();
    }
}

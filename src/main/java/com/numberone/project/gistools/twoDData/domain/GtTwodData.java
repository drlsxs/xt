package com.numberone.project.gistools.twoDData.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * GtTwodData对象 gt_2d_data
 *
 * @author hwx
 * @date 2022-04-21
 */
public class GtTwodData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** null */
    @Excel(name = "null")
    private String name;

    /** null */
    @Excel(name = "null")
    private String dataId;

    /** null */
    @Excel(name = "null")
    private String type;

    /** null */
    @Excel(name = "null")
    private String style;

    /** null */
    @Excel(name = "null")
    private String imgShow;

    /** null */
    @Excel(name = "null")
    private String billboard;

    private String url;

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
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setDataId(String dataId)
    {
        this.dataId = dataId;
    }

    public String getDataId()
    {
        return dataId;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setStyle(String style)
    {
        this.style = style;
    }

    public String getStyle()
    {
        return style;
    }
    public void setImgShow(String imgShow)
    {
        this.imgShow = imgShow;
    }

    public String getImgShow()
    {
        return imgShow;
    }
    public void setBillboard(String billboard)
    {
        this.billboard = billboard;
    }

    public String getBillboard()
    {
        return billboard;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("dataId", getDataId())
            .append("type", getType())
            .append("style", getStyle())
            .append("imgShow", getImgShow())
            .append("billboard", getBillboard())
            .toString();
    }
}

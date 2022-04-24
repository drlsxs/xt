package com.numberone.project.gistools.wms.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * wms对象 gt_wms
 *
 * @author wly
 * @date 2022-03-29
 */
public class Wms extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String wmsId;

    /** null */
    @Excel(name = "null")
    private String serviceName;

    /** null */
    @Excel(name = "null")
    private String serviceUrl;

    /** null */
    @Excel(name = "null")
    private String serviceParamter;

    /** null */
    @Excel(name = "null")
    private String filter;

    /** null */
    @Excel(name = "null")
    private String layerName;

    private String extent;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type

            ;

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }

    /** null */
    @Excel(name = "null")
    private String style;

    private String project;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    /** null */
    @Excel(name = "null")
    private Integer status;

    public void setWmsId(String wmsId)
    {
        this.wmsId = wmsId;
    }

    public String getWmsId()
    {
        return wmsId;
    }
    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public String getServiceName()
    {
        return serviceName;
    }
    public void setServiceUrl(String serviceUrl)
    {
        this.serviceUrl = serviceUrl;
    }

    public String getServiceUrl()
{
    return serviceUrl;
}
    public void setServiceParamter(String serviceParamter)
    {
        this.serviceParamter = serviceParamter;
    }

    public String getServiceParamter()
    {
        return serviceParamter;
    }
    public void setFilter(String filter)
    {
        this.filter = filter;
    }

    public String getFilter()
    {
        return filter;
    }
    public void setLayerName(String layerName)
    {
        this.layerName = layerName;
    }

    public String getLayerName()
    {
        return layerName;
    }
    public void setStyle(String style)
    {
        this.style = style;
    }

    public String getStyle()
    {
        return style;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("wmsId", getWmsId())
            .append("serviceName", getServiceName())
            .append("serviceUrl", getServiceUrl())
            .append("serviceParamter", getServiceParamter())
            .append("filter", getFilter())
            .append("layerName", getLayerName())
            .append("style", getStyle())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}

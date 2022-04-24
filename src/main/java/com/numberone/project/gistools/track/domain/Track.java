package com.numberone.project.gistools.track.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * track对象 gt_track
 *
 * @author wly
 * @date 2022-04-01
 */
public class Track extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** null */
    @Excel(name = "null")
    private String carNo;

    /** null */
    @Excel(name = "null", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gpstime;

    /** null */
    @Excel(name = "null")
    private Double lon;

    /** null */
    @Excel(name = "null")
    private Double lat;

    /** null */
    @Excel(name = "null")
    private Double imei;

    /** null */
    @Excel(name = "null")
    private Double speed;

    /** null */
    @Excel(name = "null")
    private Double bearing;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setCarNo(String carNo)
    {
        this.carNo = carNo;
    }

    public String getCarNo()
    {
        return carNo;
    }
    public void setGpstime(Date gpstime)
    {
        this.gpstime = gpstime;
    }

    public Date getGpstime()
    {
        return gpstime;
    }
    public void setLon(Double lon)
    {
        this.lon = lon;
    }

    public Double getLon()
    {
        return lon;
    }
    public void setLat(Double lat)
    {
        this.lat = lat;
    }

    public Double getLat()
    {
        return lat;
    }
    public void setImei(Double imei)
    {
        this.imei = imei;
    }

    public Double getImei()
    {
        return imei;
    }
    public void setSpeed(Double speed)
    {
        this.speed = speed;
    }

    public Double getSpeed()
    {
        return speed;
    }
    public void setBearing(Double bearing)
    {
        this.bearing = bearing;
    }

    public Double getBearing()
    {
        return bearing;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carNo", getCarNo())
            .append("gpstime", getGpstime())
            .append("lon", getLon())
            .append("lat", getLat())
            .append("imei", getImei())
            .append("speed", getSpeed())
            .append("bearing", getBearing())
            .toString();
    }
}

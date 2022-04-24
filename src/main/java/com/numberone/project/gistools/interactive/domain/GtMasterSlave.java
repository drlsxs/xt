package com.numberone.project.gistools.interactive.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 主从表对象 gt_master_slave
 *
 * @author hwx
 * @date 2022-04-20
 */
public class GtMasterSlave extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** null */
    @Excel(name = "null")
    private String masterName;

    /** null */
    @Excel(name = "null")
    private String masterField;

    /** null */
    @Excel(name = "null")
    private String masterType;

    /** null */
    @Excel(name = "null")
    private String slaveName;

    /** null */
    @Excel(name = "null")
    private String slaveField;

    /** null */
    @Excel(name = "null")
    private String slaveType;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterField() {
        return masterField;
    }

    public void setMasterField(String masterField) {
        this.masterField = masterField;
    }

    public String getMasterType() {
        return masterType;
    }

    public void setMasterType(String masterType) {
        this.masterType = masterType;
    }

    public String getSlaveName() {
        return slaveName;
    }

    public void setSlaveName(String slaveName) {
        this.slaveName = slaveName;
    }

    public String getSlaveField() {
        return slaveField;
    }

    public void setSlaveField(String slaveField) {
        this.slaveField = slaveField;
    }

    public String getSlaveType() {
        return slaveType;
    }

    public void setSlaveType(String slaveType) {
        this.slaveType = slaveType;
    }
}

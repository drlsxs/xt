package com.numberone.project.gistools.interactive.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 字典详情对象 gt_dict_data
 *
 * @author hwx
 * @date 2022-04-19
 */
public class GtDictData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** null */
    @Excel(name = "null")
    private String dictLabel;

    /** null */
    @Excel(name = "null")
    private String dictValue;

    private String dictTypeId;

    public String getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(String dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setDictLabel(String dictLabel)
    {
        this.dictLabel = dictLabel;
    }

    public String getDictLabel()
    {
        return dictLabel;
    }
    public void setDictValue(String dictValue)
    {
        this.dictValue = dictValue;
    }

    public String getDictValue()
    {
        return dictValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dictLabel", getDictLabel())
            .append("dictValue", getDictValue())
            .toString();
    }
}

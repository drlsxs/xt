package com.numberone.project.gistools.basemap.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;

import java.util.List;

/**
 * @author hwx
 * @date 2022/4/22 15:36
 */
public class GtBasemapGroup {

    private String id;

    private String baseIds;

    private String name;

    private List<GtBasemap> basemapList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GtBasemap> getBasemapList() {
        return basemapList;
    }

    public void setBasemapList(List<GtBasemap> basemapList) {
        this.basemapList = basemapList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBaseIds() {
        return baseIds;
    }

    public void setBaseIds(String baseIds) {
        this.baseIds = baseIds;
    }
}

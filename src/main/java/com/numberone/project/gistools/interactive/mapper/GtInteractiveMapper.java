package com.numberone.project.gistools.interactive.mapper;

import com.numberone.project.gistools.interactive.domain.GtInteractive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据交互配置Mapper接口
 *
 * @author hwx
 * @date 2022-04-19
 */
public interface GtInteractiveMapper
{
    /**
     * 查询数据交互配置
     *
     * @param id 数据交互配置ID
     * @return 数据交互配置
     */
    public GtInteractive selectGtInteractiveById(@Param("id") String id);

    /**
     * 查询数据交互配置列表
     *
     * @param gtInteractive 数据交互配置
     * @return 数据交互配置集合
     */
    public List<GtInteractive> selectGtInteractiveList(GtInteractive gtInteractive);

    /**
     * 新增数据交互配置
     *
     * @param gtInteractive 数据交互配置
     * @return 结果
     */
    public int insertGtInteractive(GtInteractive gtInteractive);

    /**
     * 修改数据交互配置
     *
     * @param gtInteractive 数据交互配置
     * @return 结果
     */
    public int updateGtInteractive(GtInteractive gtInteractive);

    /**
     * 删除数据交互配置
     *
     * @param id 数据交互配置ID
     * @return 结果
     */
    public int deleteGtInteractiveById(String id);

    /**
     * 批量删除数据交互配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtInteractiveByIds(String[] ids);
}

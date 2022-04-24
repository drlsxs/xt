package com.numberone.project.gistools.resource.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.numberone.project.gistools.resource.domain.Resource;
import org.apache.ibatis.annotations.Param;

/**
 * resourceMapper接口
 *
 * @author wly
 * @date 2022-03-30
 */
public interface ResourceMapper  extends BaseMapper<Resource>
{
    /**
     * 查询resource
     *
     * @param id resourceID
     * @return resource
     */
    public Resource selectResourceById(String id);

    /**
     * 查询resource列表
     *
     * @param resource resource
     * @return resource集合
     */
    public List<Resource> selectResourceList(Resource resource);

    /**
     * 新增resource
     *
     * @param resource resource
     * @return 结果
     */
    public int insertResource(Resource resource);

    /**
     * 修改resource
     *
     * @param resource resource
     * @return 结果
     */
    public int updateResource(Resource resource);

    /**
     * 删除resource
     *
     * @param id resourceID
     * @return 结果
     */
    public int deleteResourceById(String id);

    /**
     * 批量删除resource
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteResourceByIds(String[] ids);

    List<Resource> selectUnstructuredList(Resource resource);

    List<Resource> selectListByTypeList(@Param("typeList")List<Integer> typeList,
                                        @Param("fileName")String fileName);

    List<String> selectUrlByIds(@Param("ids")List<String> ids);
}

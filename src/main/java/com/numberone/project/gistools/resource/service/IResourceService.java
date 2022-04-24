package com.numberone.project.gistools.resource.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.numberone.project.gistools.resource.domain.Resource;

/**
 * resourceService接口
 *
 * @author wly
 * @date 2022-03-30
 */
public interface IResourceService extends IService<Resource>
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
     * 批量删除resource
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteResourceByIds(String ids);

    /**
     * 删除resource信息
     *
     * @param id resourceID
     * @return 结果
     */
    public int deleteResourceById(String id);

    List<Resource> selectUnstructuredList(Resource resource);

    List<Resource> selectListByTypeList(List<Integer> typeList, String fileName);

    List<String> selectUrlByIds(List<String> ids);
}

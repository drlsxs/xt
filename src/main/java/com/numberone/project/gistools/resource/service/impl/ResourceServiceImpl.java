package com.numberone.project.gistools.resource.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.numberone.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.gistools.resource.mapper.ResourceMapper;
import com.numberone.project.gistools.resource.domain.Resource;
import com.numberone.project.gistools.resource.service.IResourceService;
import com.numberone.common.utils.text.Convert;

/**
 * resourceService业务层处理
 *
 * @author wly
 * @date 2022-03-30
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService
{
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 查询resource
     *
     * @param id resourceID
     * @return resource
     */
    @Override
    public Resource selectResourceById(String id)
    {
        return resourceMapper.selectResourceById(id);
    }

    /**
     * 查询resource列表
     *
     * @param resource resource
     * @return resource
     */
    @Override
    public List<Resource> selectResourceList(Resource resource)
    {
        return resourceMapper.selectResourceList(resource);
    }

    /**
     * 新增resource
     *
     * @param resource resource
     * @return 结果
     */
    @Override
    public int insertResource(Resource resource)
    {
        resource.setCreateTime(DateUtils.getNowDate());
        return resourceMapper.insertResource(resource);
    }

    /**
     * 修改resource
     *
     * @param resource resource
     * @return 结果
     */
    @Override
    public int updateResource(Resource resource)
    {
        resource.setUpdateTime(DateUtils.getNowDate());
        return resourceMapper.updateResource(resource);
    }

    /**
     * 删除resource对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteResourceByIds(String ids)
    {
        return resourceMapper.deleteResourceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除resource信息
     *
     * @param id resourceID
     * @return 结果
     */
    @Override
    public int deleteResourceById(String id)
    {
        return resourceMapper.deleteResourceById(id);
    }

    @Override
    public List<Resource> selectUnstructuredList(Resource resource) {
        return resourceMapper.selectUnstructuredList(resource);
    }

    @Override
    public List<Resource> selectListByTypeList(List<Integer> typeList, String fileName) {
        return resourceMapper.selectListByTypeList(typeList,fileName);
    }

    @Override
    public List<String> selectUrlByIds(List<String> ids) {
        return resourceMapper.selectUrlByIds(ids);
    }
}

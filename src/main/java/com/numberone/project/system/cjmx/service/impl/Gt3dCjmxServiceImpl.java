package com.numberone.project.system.cjmx.service.impl;

import java.util.List;
import com.numberone.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.cjmx.mapper.Gt3dCjmxMapper;
import com.numberone.project.system.cjmx.domain.Gt3dCjmx;
import com.numberone.project.system.cjmx.service.IGt3dCjmxService;
import com.numberone.common.utils.text.Convert;

/**
 * 场景模型Service业务层处理
 *
 * @author xskj
 * @date 2022-03-31
 */
@Service
public class Gt3dCjmxServiceImpl implements IGt3dCjmxService
{
    @Autowired
    private Gt3dCjmxMapper gt3dCjmxMapper;

    /**
     * 查询场景模型
     *
     * @param id 场景模型ID
     * @return 场景模型
     */
    @Override
    public Gt3dCjmx selectGt3dCjmxById(String id)
    {
        return gt3dCjmxMapper.selectGt3dCjmxById(id);
    }

    /**
     * 查询场景模型列表
     *
     * @param gt3dCjmx 场景模型
     * @return 场景模型
     */
    @Override
    public List<Gt3dCjmx> selectGt3dCjmxList(Gt3dCjmx gt3dCjmx)
    {
        return gt3dCjmxMapper.selectGt3dCjmxList(gt3dCjmx);
    }

    /**
     * 新增场景模型
     *
     * @param gt3dCjmx 场景模型
     * @return 结果
     */
    @Override
    public int insertGt3dCjmx(Gt3dCjmx gt3dCjmx)
    {
        return gt3dCjmxMapper.insertGt3dCjmx(gt3dCjmx);
    }

    /**
     * 修改场景模型
     *
     * @param gt3dCjmx 场景模型
     * @return 结果
     */
    @Override
    public int updateGt3dCjmx(Gt3dCjmx gt3dCjmx)
    {
        gt3dCjmx.setUpdateTime(DateUtils.getNowDate());
        return gt3dCjmxMapper.updateGt3dCjmx(gt3dCjmx);
    }

    /**
     * 删除场景模型对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGt3dCjmxByIds(String ids)
    {
        return gt3dCjmxMapper.deleteGt3dCjmxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除场景模型信息
     *
     * @param id 场景模型ID
     * @return 结果
     */
    @Override
    public int deleteGt3dCjmxById(Long id)
    {
        return gt3dCjmxMapper.deleteGt3dCjmxById(id);
    }
}

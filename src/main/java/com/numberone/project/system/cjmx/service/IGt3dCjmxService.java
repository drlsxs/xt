package com.numberone.project.system.cjmx.service;

import java.util.List;
import com.numberone.project.system.cjmx.domain.Gt3dCjmx;

/**
 * 场景模型Service接口
 *
 * @author xskj
 * @date 2022-03-31
 */
public interface IGt3dCjmxService
{
    /**
     * 查询场景模型
     *
     * @param id 场景模型ID
     * @return 场景模型
     */
    public Gt3dCjmx selectGt3dCjmxById(String id);

    /**
     * 查询场景模型列表
     *
     * @param gt3dCjmx 场景模型
     * @return 场景模型集合
     */
    public List<Gt3dCjmx> selectGt3dCjmxList(Gt3dCjmx gt3dCjmx);

    /**
     * 新增场景模型
     *
     * @param gt3dCjmx 场景模型
     * @return 结果
     */
    public int insertGt3dCjmx(Gt3dCjmx gt3dCjmx);

    /**
     * 修改场景模型
     *
     * @param gt3dCjmx 场景模型
     * @return 结果
     */
    public int updateGt3dCjmx(Gt3dCjmx gt3dCjmx);

    /**
     * 批量删除场景模型
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGt3dCjmxByIds(String ids);

    /**
     * 删除场景模型信息
     *
     * @param id 场景模型ID
     * @return 结果
     */
    public int deleteGt3dCjmxById(Long id);
}

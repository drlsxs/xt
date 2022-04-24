package com.numberone.project.gistools.twoDStyle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

/**
 * @author hwx
 * @date 2022/4/12 9:11
 */
public interface StyleMapper extends BaseMapper<T> {
    List<Map> findWorkSpace();

    void insertPicture(@Param("id") String id,
                       @Param("base") String base,
                       @Param("name") String name);
}

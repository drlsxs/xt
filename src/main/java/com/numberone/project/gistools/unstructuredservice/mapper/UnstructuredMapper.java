package com.numberone.project.gistools.unstructuredservice.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hwx
 * @date 2022/4/1 17:29
 */
public interface UnstructuredMapper {
    List<String> getAllTableName();

    List<Map> getPageByTableName(@Param("tableName") String tableName);

    List<String> getTableMsgByTableName(@Param("tableName")String tableName);
}

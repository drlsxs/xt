package com.numberone.framework.config;

import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeReference;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther:wly
 * @Date:2022/3/28 11:13
 * @version:1.0
 */
public abstract class BaseTypeHandle<T> extends TypeReference<T> implements TypeHandler<T> {
    @Override
    public T getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}

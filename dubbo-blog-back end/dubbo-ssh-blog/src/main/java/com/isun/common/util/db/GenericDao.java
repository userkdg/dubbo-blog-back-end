package com.isun.common.util.db;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Dao通用接口
 */

public interface GenericDao<T, PK extends Serializable> {

    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();
}

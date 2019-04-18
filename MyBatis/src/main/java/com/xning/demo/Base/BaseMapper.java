package com.xning.demo.Base;

import java.util.List;

public interface BaseMapper<T> {
    /**
     * ID 获取单条数据
     *
     * @param id
     * @return
     */
    T get(String id);

    /**
     * 实体类查询多条数据
     *
     * @param t
     * @return
     */
    List<T> findList(T t);

    /**
     * 保存
     *
     * @param t
     */
    void insert(T t);

    /**
     * 更新
     *
     * @param t
     */
    void update(T t);

    /**
     * id删除单条数据
     *
     * @param id
     */
    void delete(String id);
}

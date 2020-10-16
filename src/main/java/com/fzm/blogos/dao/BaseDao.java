package com.fzm.blogos.dao;


public interface BaseDao<T> {

    /**
     * 更新数据
     *
     * @param t 数据
     * @return 操作影响的行数
     */
    int update(T t);

    /**
     * 根据id删除数据
     *
     * @param id id
     * @return 操作影响的行数
     */
    int delete(int id);

    /**
     * 新增数据
     *
     * @param t 数据
     * @return 操作影响的行数
     */
    int insert(T t);

}

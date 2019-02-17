package com.zdn;

/**
 * @Description: Map接口
 * @Author: zdn
 * @CreateDate: 2019/2/17
 * @Version: 1.0
 */
public interface MyMap<K,V> {

    /**
     * 向集合中插入数据
     * @param key
     * @param value
     * @return
     */
    V put(K key,V value);

    /**
     * 根据Key在集合中获取数据
     * @param key
     * @return
     */
    V get(Object key);

    /**
     * 集合的大小
     * @return
     */
    int size();

    /**
     * Key与Value的关系
     * @param <K>
     * @param <V>
     */
    interface Entry<K,V>{
        K getKey();

        V getValue();

        V setValue(V value);
    }
}

package com.zzb.dataStructure.hashmap;

import java.util.*;
import java.util.HashMap;

/**
 * @Author by 张志斌 .
 * @Date 18:38 2019/3/28
 */
public  class Node<K, V> implements Map.Entry<K,V>{
    int hash;
    K key;
    V value;
    Node<K,V> next;

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return this.value;
    }

    /**
     * 重写hashCode方法，返回key和value的hashCode
     * @return
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
}

package com.zzb.dataStructure.hashmap;

/**
 * @Author by 张志斌 .
 * @Date 18:36 2019/3/28
 */
public class HashMap<K,V> {
    /**
     * 数组链表，即数组中每一个元素都是一个链表
     */
    transient Node<K,V>[] table;
    /**
     * 默认容量为16
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    /**
     * 最大容量不能超过2的30次方
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 扩容系数，当数组的长度超过 系数 * 数组容量的时候，数组进行扩容
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 根据key计算对应的hash值,调用object的本地方法hashCode，获得一个int型的数据，然后与这个数据数据有符号右移16位后的数据异或，
     * 这么做其实是为了打乱高16位和低16位之间的顺序，一个好的hash算法可以尽量保证计算出来的hash值不重复
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

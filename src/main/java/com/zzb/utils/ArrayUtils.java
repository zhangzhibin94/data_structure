package com.zzb.utils;

import java.util.*;

/**
 * Created by zzb on 2019/1/31.
 * @Author zzb
 * @Description 模拟arrayList的实现
 *
 */
public  class ArrayUtils<T> extends AbstractList<T>
        implements List<T> {
    //数组长度
    private int size;
    //数组容量
    private int capacity = 10;
    //数组扩容系数
    private static final double resizeCoefficient = 1F;
    //声明的数组为一个全局变量
    transient   Object[] arr ;
    //默认容量为空的数组
    private static final Object[] DEFAULT_CAPACITY_EMPTY = {};

    /**
     * 重写构造函数，初始化数组
     */
    public ArrayUtils(int initialCapacity){
        if (initialCapacity > 0) {
            this.arr = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.arr = DEFAULT_CAPACITY_EMPTY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }
    public ArrayUtils(){//无参构造函数,默认容量为10
        this.arr = DEFAULT_CAPACITY_EMPTY;
    }
    /**
     * 获得数组长度
     * @return 数组长度
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * 数组下标越界检查
     */
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("数组下标越界，越界下标："+index);
    }

    /**
     * 判断数组是否为空数组
     * @return
     */
    @Override
    public boolean isEmpty() {
        //官方写法就一句话 ：return size == 0;
        return size == 0;
    }

    /**
     * 数组中是否包含元素o
     * @param o
     * @return
     */
    @Override
    public boolean contains(Object o) {
        int i = indexFor(o);
        return i>=0;//返回值为-1说明这个元素不存在
    }

    /**
     * 根据数组元素查询其对应的数组下标
     * @param o
     * @return
     */
    public int indexFor(Object o){
        //如果入参o为空，则查询数组中第一个为空的元素并返回对应的数组下标
        if(null==o){
            for(int i = 0; i < size; i++){
                if(arr[i]==null)
                    return i;
            }
        }else {//如果入参o不为空，则查询数组中与元素o相匹配的元素
            for(int i = 0; i < size; i++){
                if(o.equals(arr[i])){
                    return i;
                }
            }
        }
        //如果并没有在数组中找到元素o，则返回-1
        return -1;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    /**
     * 向数组中添加元素t
     * @param t
     * @return
     */
    @Override
    public boolean add(T t) {
        //先判断数组是否满了（即开辟的数组空间是否还可以继续存放元素）
        if(size>=arr.length){//如果满了，则扩容
            resize();
        }
        //在数组末尾添加元素t
        arr[size++] = t;
        return true;
    }

    /**
     * 判断是否需要扩容
     */
    public boolean shouldResize(int resize){
        //如果数组长度大于容量*扩容系数，则进行扩容
        return resize > resizeCoefficient * capacity;

    }
    //对数组进行扩容，容量为原数组容量的两倍
    public void resize(){
        //1.声明一个是原来数组两倍的新数组
       /* T[] newArr = (T[]) new Object[capacity<<1];
        //2.将旧数组中的元素拷贝到新数组中（深拷贝）
        System.arraycopy(arr, 0, newArr, 0, capacity);

        //3.将原数组覆盖
        arr = newArr;*/

        int oldCapacity = arr.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if(newCapacity<=0){
            newCapacity = 10;
        }
        // minCapacity is usually close to size, so this is a win:
        arr = Arrays.copyOf(arr, newCapacity);
    }

    /**
     * 删除数组中某个元素
     * @param o 数组中的元素
     * @return
     */
    @Override
    public boolean remove(Object o) {
        for(int i =0;arr.length<size;i++){
            if(o.equals(arr[i])){
                this.fastRemove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 根据数组下标快速删除元素
     * @param index 数组下标
     */
    private void fastRemove(int index) {
        rangeCheck(index);//检查数组下标是否越界
        //如果一个数组为[1,3,5,9,13]要删除元素3（下标为1），则需要将所有元素3后面的元素都往前移动一个位置，
        // 那么需要拷贝的元素就是元素3后面的所有元素，需要拷贝的元素个数为：数组大小5 - 数组下标1 - 1 = 3
        int numMoved = size - index - 1;
        if (numMoved > 0)
            //1.调用本地方法对数组进行深拷贝，将所有在需要删除的元素的后面的数组元素往前移动一个位置
            System.arraycopy(arr, index+1, arr, index,
                    numMoved);
        //2.将需要删除的元素设置为null，交给垃圾回收机制回收
        arr[--size] = null; // clear to let GC do its work
    }

    /**
     * 将数组与集合collection合并到数组末尾元素后边
     * Collection<? extends T> collection 声明所有集合元素可以是泛型T的子类
     * @param collection
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends T> collection) {
        //将集合元素collection转化为数组
        Object[] newArr = collection.toArray();
        //1.先判断是否需要扩容
        if(size+newArr.length>=capacity){
            resize();
        }
        //2.将所有集合元素拷贝到数组元素的末尾后边
        System.arraycopy(newArr,0,arr,size,newArr.length);
        size+=newArr.length;
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    /**
     * 删除所有数组中的元素
     */
    @Override
    public void clear() {
        //1.将数组中的所有元素都设置为null，方便垃圾回收机制回收
        for(int i = 0; i <arr.length; i++){
            arr[i] = null;
        }
        //2.设置数组大小为0
        size = 0;
    }

    @Override
    public T get(int index) {
        return (T)arr[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    /**
     * 根据数组元素下标删除指定的元素
     * @param index
     * @return 被删除的元素
     */
    @Override
    public T remove(int index) {

        fastRemove(index);
        return (T)arr[index];

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    /**
     * 将数组转为字符串
     * @return
     */
    public  static String arrayToString(Object[] a){
        StringBuilder sb = new StringBuilder();
        if(a==null||a.length==0){
            return "[]";
        }
        sb.append("[");
        for(int i = 0; i < a.length;i++){
            sb.append(a[i]);
        }
        String s = sb.append("]").toString();
        return  s;
    }

    @SuppressWarnings("unchecked")
    T arr(int index) {
        return (T) arr[index];
    }

    public static void main(String[] args) { // main 方法本身放入方法区。
        ArrayUtils test1 = new ArrayUtils(); // test1是引用，所以放到栈区里，new Sample(" 测试1 ")放入到堆区
    }
}

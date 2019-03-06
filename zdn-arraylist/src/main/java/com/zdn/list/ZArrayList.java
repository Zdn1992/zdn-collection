package com.zdn.list;

import java.util.Arrays;

public class ZArrayList<E> implements ZList<E> {

    /**
     * 数组初始化大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 存数据的数组
     */
    transient Object[] elementData;

    /**
     * list的长度
     */
    private int size;


    public ZArrayList() {
        // 无参构造器,默认创建长度为10的数组
        this(DEFAULT_CAPACITY);
    }

    public ZArrayList(int capacity) {
        this.elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        if (index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    @Override
    public boolean add(E e) {
        // 1.判断是否已经达到了数组的容量上限
        ensureCapacity(size + 1);
        // 2.将元素设置到数组当中
        elementData[size++] = e;
        return true;
    }

    /**
     * @param minCapacity 目前数组容器中的元素个数
     */
    private void ensureCapacity(int minCapacity) {
        // 当前数组的容量
        int oldCapacity = elementData.length;
        // 大于数组的容量大小,进行扩容
        if (minCapacity > oldCapacity) {
            // 长度扩容1.5倍, 右移运算符，num >> 1,相当于num除以2
            int newCapacity = oldCapacity + oldCapacity >> 1;
            if (newCapacity < minCapacity) {
                // 多线程相关
                newCapacity = minCapacity;
            }
            // 复制老数组到新的数组
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

}

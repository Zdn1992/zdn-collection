package com.zdn.list;

public interface ZList<E> {

    boolean add(E e);

    int size();

    boolean isEmpty();

    E get(int index);
}

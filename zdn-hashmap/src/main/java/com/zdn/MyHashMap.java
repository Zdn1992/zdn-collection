package com.zdn;

/**
 * @Description: HashMap实现类
 * @Author: zdn
 * @CreateDate: 2019/2/17
 * @Version: 1.0
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    /**
     * K,V节点 默认为null 进行懒加载
     */
    Node<K, V>[] table;

    /**
     * 容器里元素的大小
     */
    int size;

    /**
     * 负载因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 默认Node数组初始化大小
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @Override
    public V put(K key, V value) {
        // 1,判断table数组是否为空
        if (table == null || table.length == 0) {
            table = new Node[DEFAULT_INITIAL_CAPACITY];
        }

        // 2,计算key hashcode的值,得到在table数组的下标
        // table的长度应该为2的整数幂, 这样保证length - 1低位全是1
        // 保证与操作后,得到的下标总是落在数组的范围长度,不会出现越界
        int index = hash(key) & (table.length - 1);
        Node<K, V> node = table[index];

        // 3,判断当前数组下标的位置是否已经存在节点
        if (node == null) {
            // 如果位置为null,直接将设置进去
            node = new Node<>(key, value, null);
            size++;
            return node.setValue(value);
        } else {
            // 如果当前数组位置的不为空
            Node<K, V> tempNode = node;
            if (tempNode.next == null) {
                // 此时占据数据index位置的链表只有一个
                if (tempNode.getKey().equals(key) && tempNode.next.getKey() == key) {
                    return tempNode.next.setValue(value);
                }
                node = new Node<>(key, value, tempNode);
                size ++;
            } else {
                while (tempNode.next != null) {
                    //
                    if (tempNode.next.getKey().equals(key) && tempNode.next.getKey() == key) {
                        return tempNode.next.setValue(value);
                    }
                    // 已经到单项链表的最后一个节点了
                    if (tempNode.next == null) {
                        // 参数里面的node为链表头中node,就是第一个node
                        node = new Node<>(key, value, tempNode);
                        size++;
                    }
                    tempNode = tempNode.next;
                }
            }
        }
        table[index] = node;
        return null;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int hash(Object key) {
        int h;
        // 充分利用低位和高位,使二进制"1"分布的更均匀. 减少hash碰撞
        return key == null ? 0 : ((h = key.hashCode()) ^ (h >>> 16));
    }

    class Node<K, V> implements Entry<K, V> {

        int hash;

        /**
         * Map集合中的Key
         */
        private K k;

        /**
         * Map集合中的Value
         */
        private V v;

        Node<K, V> next;

        public Node(K k, V v, Node<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.k;
        }

        @Override
        public V getValue() {
            return this.v;
        }


        @Override
        public V setValue(V value) {
            V oldValue = this.v;
            this.v = value;
            return oldValue;
        }
    }
}

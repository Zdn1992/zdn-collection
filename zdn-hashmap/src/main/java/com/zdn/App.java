package com.zdn;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MyMap<String,Object> map = new MyHashMap<>();
        map.put("one","一");
        map.put("two","二");
        map.put("three","三");
        map.put("four","四");
        System.out.println(map.size());
    }
}

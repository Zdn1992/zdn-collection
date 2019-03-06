package com.zdn;


import com.zdn.list.ZArrayList;
import com.zdn.list.ZList;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testList(){
        System.out.println("........myList start........");
        ZList<String> zList = new ZArrayList<>();
        zList.add("张三");
        zList.add("李四");
        zList.add("王五");
        zList.add("赵六");
        for (int i = 0; i < zList.size(); i++) {
            System.out.println(zList.get(i));
        }
        System.out.println("........myList end........");
    }
}

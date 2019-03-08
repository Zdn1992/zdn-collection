package com.zdn;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void myHashMap(){
        ZMap<String,Object> map = new ZHashMap<>();
        System.out.println(map.put("aA", "一"));
        System.out.println(map.put("BB", "二"));
        System.out.println(map.put("BB", "三"));
        System.out.println(map.put("four", "四"));
        System.out.println(map.size());
    }
}

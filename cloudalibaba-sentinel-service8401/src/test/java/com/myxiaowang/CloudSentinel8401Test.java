package com.myxiaowang;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CloudSentinel8401Test
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String s ="";
        int counter = 0;
        while (true){
            s=s+counter+++"";
            System.out.println(s);
            System.out.println("当前字符串长度"+counter);
        }
    }
}

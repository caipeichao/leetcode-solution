package com.caipeichao.leetcode;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution34Test {

    @Test(dataProvider = "a")
    public void testSearchRange(String input, int target, String expect) throws Exception {
        int[] nums = TestUtils.parseJsonArray(input);
        int[] actual = new Solution34().searchRange(nums, target);
        String actualString = JSON.toJSONString(actual);
        assertEquals(actualString, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"[]",5,"[-1,-1]"},
                new Object[]{"[1]",1,"[0,0]"},
                new Object[]{"[1]",0,"[-1,-1]"},
                new Object[]{"[1,2]",1,"[0,0]"},
                new Object[]{"[1,2]",2,"[1,1]"},
                new Object[]{"[1,2]",3,"[-1,-1]"},
                new Object[]{"[1,2]",0,"[-1,-1]"},
                new Object[]{"[5,7,7,8,8,10]",5,"[0,0]"},
                new Object[]{"[5,7,7,8,8,10]",7,"[1,2]"},
                new Object[]{"[5,7,7,8,8,10]",8,"[3,4]"},
                new Object[]{"[5,7,7,8,8,10]",10,"[5,5]"},
                new Object[]{"[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17]",5,"[4,4]"},
                new Object[]{"[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17]",1,"[0,0]"},
                new Object[]{"[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17]",17,"[16,16]"},
                new Object[]{"[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]",1,"[0,20]"},
                new Object[]{"[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]",0,"[-1,-1]"},
                new Object[]{"[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]",1,"[0,19]"},
                new Object[]{"[0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]",1,"[1,20]"},
                new Object[]{"[0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]",1,"[1,19]"},
        };
    }
}
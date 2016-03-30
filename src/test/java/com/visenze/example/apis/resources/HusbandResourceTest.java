package com.visenze.example.apis.resources;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by guojing on 21/9/15.
 */
public class HusbandResourceTest {
    private HusbandResource husband = new HusbandResource();

    @Test
    public void testShop() throws Exception {
        Map<String, Integer> result = (Map<String, Integer>)this.husband.shop();
        try {
            int countEggs = result.get("eggs");
            int countMilk = result.get("milk");
            if (countEggs != 12 || countMilk != 1) {
                Assert.fail("Test failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }
    }

    @Test
    public void testGetMilkCount() throws Exception {
        int result = this.husband.getMilkCount();
        assertEquals(result, 0);
    }

    @Test
    public void testGetEggCount() throws Exception {
        int result = this.husband.getEggCount();
        assertEquals(result, 0);
    }
}
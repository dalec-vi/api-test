package com.visenze.example.apis.resources;

import com.visenze.example.apis.services.StoreItemService;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by guojing on 21/9/15.
 */
public class HusbandResourceTest {
    StoreItemService storeItemService = new StoreItemService();
    private HusbandResource husband = new HusbandResource(storeItemService);

    @Test
    public void testShop() throws Exception {
        Map<String, Integer> result = (Map<String, Integer>)this.husband.shop();
        try {
            int countEggs = result.get("eggs_bought");
            int countMilk = result.get("milk_bought");
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
        String result = this.husband.getMilkCount().get("milk");
        assertEquals(result, "0");
    }

    @Test
    public void testGetEggCount() throws Exception {
        String result = this.husband.getEggCount().get("eggs");
        assertEquals(result, "0");
    }
}
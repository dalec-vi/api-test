package com.visenze.example.apis.resources;

import com.google.common.base.Optional;

import com.visenze.example.apis.services.StoreItemService;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by guojing on 21/9/15.
 */
public class StoreResourceTest {
    StoreItemService storeItemService = new StoreItemService();
    private StoreResource store = new StoreResource(storeItemService);

    @Test
    public void testHasMilk() throws Exception {
        String result = this.store.hasMilk().get("milk_stock");
        assertEquals(result, "1000");
    }

    @Test
    public void testHasEggs() throws Exception {
        String result = this.store.hasEggs().get("eggs_stock");
        assertEquals(result, "1000");
    }

    @Test
    public void testBuy_0() throws Exception {
        String error = this.store.buyMilk(Optional.of(0)).get("error");
        String errCode = this.store.buyMilk(Optional.of(0)).get("err_code");
        assertEquals(error, "1");
        assertEquals(errCode, "101");
    }

    @Test
    public void testBuyMilk_1() throws Exception {
        String result = this.store.buyMilk(Optional.of(1)).get("qty_bought");
        assertEquals(result, "1");
    }

    @Test
    public void testBuyMilk_1000() throws Exception {
        String result = this.store.buyMilk(Optional.of(1000)).get("qty_bought");
        assertEquals(result, "1000");
    }

    @Test
    public void testBuyMilk_1001() throws Exception {
        String result = this.store.buyMilk(Optional.of(1001)).get("qty_bought");
        assertEquals(result, "0");
    }

    @Test
    public void testBuyEggs_0() throws Exception {
        String error = this.store.buyEggs(Optional.of(0)).get("error");
        String errCode = this.store.buyEggs(Optional.of(0)).get("err_code");
        assertEquals(error, "1");
        assertEquals(errCode, "101");
    }

    @Test
    public void testBuyEggs_1() throws Exception {
        String result = this.store.buyEggs(Optional.of(1)).get("qty_bought");
        assertEquals(result, "1");
    }

    @Test
    public void testBuyEggs_1000() throws Exception {
        String result = this.store.buyEggs(Optional.of(1000)).get("qty_bought");
        assertEquals(result, "1000");
    }

    @Test
    public void testBuyEggs_1001() throws Exception {
        String result = this.store.buyEggs(Optional.of(1001)).get("qty_bought");
        assertEquals(result, "0");
    }
}

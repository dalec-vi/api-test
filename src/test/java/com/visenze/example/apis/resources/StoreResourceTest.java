package com.visenze.example.apis.resources;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by guojing on 21/9/15.
 */
public class StoreResourceTest {
    private StoreResource store = new StoreResource();

    @Test
    public void testHasMilk() throws Exception {
        int result = this.store.hasMilk();
        assertEquals(result, 1000);
    }

    @Test
    public void testHasEggs() throws Exception {
        int result = this.store.hasEggs();
        assertEquals(result, 1000);
    }

    @Test
    public void testBuy_0() throws Exception {
        int result = this.store.buyMilk(Optional.of(0));
        assertEquals(result, 0);
    }

    @Test
    public void testBuyMilk_1() throws Exception {
        int result = this.store.buyMilk(Optional.of(1));
        assertEquals(result, 1);
    }

    @Test
    public void testBuyMilk_1000() throws Exception {
        int result = this.store.buyMilk(Optional.of(1000));
        assertEquals(result, 1000);
    }

    @Test
    public void testBuyMilk_1001() throws Exception {
        int result = this.store.buyMilk(Optional.of(1001));
        assertEquals(result, 1000);
    }

    @Test
    public void testBuyEggs_0() throws Exception {
        int result = this.store.buyEggs(Optional.of(0));
        assertEquals(result, 0);
    }

    @Test
    public void testBuyEggs_1() throws Exception {
        int result = this.store.buyEggs(Optional.of(1));
        assertEquals(result, 1);
    }

    @Test
    public void testBuyEggs_1000() throws Exception {
        int result = this.store.buyEggs(Optional.of(1000));
        assertEquals(result, 1000);
    }

    @Test
    public void testBuyEggs_1001() throws Exception {
        int result = this.store.buyEggs(Optional.of(1001));
        assertEquals(result, 1000);
    }
}

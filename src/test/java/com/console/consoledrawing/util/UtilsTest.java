package com.console.consoledrawing.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @org.junit.Test
    public void toPositiveInt() throws Exception {
        assertEquals(Utils.toPositiveInt("11"), 11);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void toPositiveInt2() throws Exception {
        Utils.toPositiveInt("0");
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void toPositiveInt3() throws Exception {
        Utils.toPositiveInt("aa");
    }

    @Test
    public void shouldAllPositive() throws Exception {
        Utils.shouldAllPositive(1, 2, 3, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAllPositive2() throws Exception {
        Utils.shouldAllPositive(1, -2, 3, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAllPositive3() throws Exception {
        Utils.shouldAllPositive(1, 2, 0, 4);
    }

    @Test
    public void shouldAllNonNegative2() throws Exception {
        Utils.shouldAllPositive(1, 2, 3, 4);
    }

    public void shouldAllNonNegative() {
        Utils.shouldAllNonNegative(1, 2, 0, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAllNonNegative3() throws Exception {
        Utils.shouldAllPositive(1, -2, 3, 4);
    }


}
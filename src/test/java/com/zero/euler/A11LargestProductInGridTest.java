package com.zero.euler;

import com.zero.euler.level001.A11LargestProductInGrid;
import org.junit.jupiter.api.Test;

class A11LargestProductInGridTest {

    @Test
    void testFindLargestProductInGrid() {
        int a = A11LargestProductInGrid.findLargestProductInGrid();
        System.out.println("a = " + a);
    }
}
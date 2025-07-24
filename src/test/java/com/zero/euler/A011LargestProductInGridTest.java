package com.zero.euler;

import com.zero.euler.part0001.A011LargestProductInGrid;
import org.junit.jupiter.api.Test;

class A011LargestProductInGridTest {

    @Test
    void testFindLargestProductInGrid() {
        int a = A011LargestProductInGrid.findLargestProductInGrid();
        System.out.println("a = " + a);
    }
}
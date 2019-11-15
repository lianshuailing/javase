package com.itheima.demo04.Supplier;

import java.util.function.Supplier;

/**
 * @author shkstart
 * @create 2019-11-07 15:47
 */
public class Demo03SupplierTest {

    public static int getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }


    public static void main(String[] args) {

        //定义数组int[]
        int[] ints = {1,2,10,100,30,400};

        int maxValue = getMax(() -> {
            int max = ints[0];

            for (int i = 1; i < ints.length; i++) {
                if (ints[i] > max) {
                    max = ints[i];
                }
            }
            return max;
        });

        System.out.println(maxValue);
    }
}

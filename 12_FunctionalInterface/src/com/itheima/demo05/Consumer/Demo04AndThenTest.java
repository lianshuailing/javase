package com.itheima.demo05.Consumer;

import java.util.function.Consumer;

/**
 * @author shkstart
 * @create 2019-11-08 9:55
 */
public class Demo04AndThenTest {

    public static void method(String[] arr, Consumer<String> consumer1, Consumer<String> consumer2) {
        for (String str : arr) {
            consumer1.andThen(consumer2).accept(str);
        }
    }


    public static void main(String[] args) {
        String[] arr = {"杨幂,女", "海清,女", "黄磊,男"};

        method(arr, (str) -> {
            String name = str.split(",")[0];
            System.out.print("姓名：" + name);
        }, (str) -> {
            String xb = str.split(",")[1];
            System.out.println("，性别：" + xb + "。");
        });
    }
}

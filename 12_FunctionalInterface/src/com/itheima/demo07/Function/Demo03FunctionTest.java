package com.itheima.demo07.Function;

import java.util.function.Function;

/**
 * 练习：自定义函数模型拼接
 * 题目:
    请使用 Function 进行函数模型的拼接，按照顺序需要执行多个函数操作为：
      String str = "赵丽颖,20";
      1. 将字符串截取数字年龄部分，得到字符串；
      2. 将上一步的字符串转换成为int类型的数字；
      3. 将上一步的int数字累加100，得到结果int数字。
 *
 * @create 2019-11-08 11:46
 */
public class Demo03FunctionTest {

    public static Integer method(String s, Function<String, Integer> fun1, Function<Integer, Integer> fun2) {
        return fun1.andThen(fun2).apply(s);
    }

    public static void main(String[] args) {

        String str = "赵丽颖,20";

        int newAge = method(str, (s) -> {
            String age = s.split(",")[1];

            return Integer.parseInt(age);
        }, (s) -> {
            return s + 100;
        });

        System.out.println(newAge);
    }

}

package com.itheima.demo06.Predicate;

import java.util.function.Predicate;

/**
 练习：集合信息筛选
 数组当中有多条“姓名+性别”的信息如下，
     String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
     请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中，
     需要同时满足两个条件：
     1. 必须为女生；
     2. 姓名为4个字。

 * @create 2019-11-08 11:07
 */
public class Demo06PredicateTest {

    public static void method(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
        for (String s : arr) {
            pre1.and(pre2).test(s);
        }
    }


    public static void main(String[] args) {
       String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};

       method(array, (s) -> {
           String xb = s.split(",")[1];
           if(xb.equals("女")) {
               //System.out.println("性别满足女：" + s.split(",")[1]);
               return true;
           }else {
               return false;
           }

       }, (s) -> {
           String name = s.split(",")[0];
           if (name.length() == 4) {
               System.out.println("性别是：女，同时满足名字为4个字的人为：" + name +"。");
               return true;
           }else {
               return false;
           }
       });
    }

}

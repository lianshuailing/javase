package com.itheima.demo01.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 因ArrayList不是线程安全的，所以在遍历的过程中(无论fori还是foreach) 禁止删除remove元素！
 *
 *
 * @create 2019-11-15 9:26
 */
public class ListForeachRemoveErr {

    public static void main(String[] args) {
        System.gc();

        //创建一个List集合对象,多态
        List<String> list = new ArrayList<>();
        //使用add方法往集合中添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

//        for (String s : list) {
//            System.out.println(s);
//        }

        // 测试1：
        // 测试fori 遍历过程中删除一个元素
        for (int i = 0; i < list.size(); i++) {
            if (i == 1) {
                list.remove(i);
            }else {
                System.out.println(list.get(i));
            }
        }




        // 测试2
        // 测试foreach 遍历过程中删除一个元素
//        for (String s : list) {
//            if (s.equals("b")) {
//                list.remove(s);
//            }else {
//                System.out.println(s);
//            }
//        }
//        a
//        Exception in thread "main" java.util.ConcurrentModificationException
//        at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
//        at java.util.ArrayList$Itr.next(ArrayList.java:859)
//        at com.itheima.demo01.List.ListForeachRemoveErr.main(ListForeachRemoveErr.java:40)




    }

}

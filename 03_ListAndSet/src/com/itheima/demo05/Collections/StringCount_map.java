package com.itheima.demo05.Collections;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2019-11-06 19:00
 */
public class StringCount_map {
    public static void main(String[] args) {
        // 统计各字符出现的次数
        String str = "abcdabcd";
        char[] chars = str.toCharArray();
//        System.out.println(chars);

        // k放字符 v放出现的次数
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (char c : chars) {
            if (hashMap.containsKey(c)) {
                Integer integer = hashMap.get(c);
                if (integer == null){
                    hashMap.put(c, 1);
                }else {
                    hashMap.put(c, hashMap.get(c) + 1);
                }
            }else {
                hashMap.put(c, 1);
            }
        }

//        System.out.println("hashMap为 " + hashMap);




//        for (char c : chars) {
//            if (!hashMap.containsKey(c)) {
//                hashMap.put(c, 1);
//            }else {
//                Integer integer = hashMap.get(c);
//                if(integer != null) {
//                    hashMap.put(c, integer + 1);
//                }else {
//                    hashMap.put(c, 1);
//                }
//            }
//        }


/*
        //方式一：
        Set<Character> set = hashMap.keySet();
        System.out.println("set为 " + set);

        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            Integer value = hashMap.get(key);
            System.out.println(key + ":" +value);
        }


        //方式二：
        for (Map.Entry<Character, Integer> entryMap : hashMap.entrySet()) {
            Character key = entryMap.getKey();
            Integer value = entryMap.getValue();
            System.out.println(key + ":" + value);
        }
*/
        //方式3：
        for(Character key : hashMap.keySet()) {
            Integer value = hashMap.get(key);
            System.out.println(key + ":" +value);
        }

    }
}

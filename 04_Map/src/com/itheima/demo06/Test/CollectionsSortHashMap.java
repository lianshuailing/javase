package com.itheima.demo06.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-11-10 21:47
 */
public class CollectionsSortHashMap {
    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "nihao");
        hashMap.put("a", "nihao");
        hashMap.put("重地", "nihao");
        hashMap.put("通话", "nihao");
        hashMap.put("e", "nihao");

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
        }

    }
}

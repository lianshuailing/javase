package com.itheima.demo03.LambdaTest;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author shkstart
 * @create 2019-11-07 14:59
 */
public class Demo03ComparatorTest {
    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("a", 30));
        list.add(new Person("b", 20));

//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                //return o1.getName().compareTo(o2.getName());
//                return o1.getAge()-o2.getAge();
//            }
//        });
//
//        System.out.println(list);


        // lambda方式：
//        Collections.sort(list, (Person o1, Person o2) -> {
//            return o1.getName().compareTo(o2.getName());
//            //return o1.getAge()-o2.getAge();
//        });
//
//        System.out.println(list);


        // lambda---简化方式：
        Collections.sort(list, (Person o1, Person o2) -> o1.getAge()-o2.getAge());
        System.out.println(list);
    }
}

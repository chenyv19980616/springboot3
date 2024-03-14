package com.atguigu.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : chenyv
 * @since :  2024-03-14 10:02:02
 **/

public class Lambda {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Jack");
        names.add("David");
        Collections.sort(names, String::compareTo);
        System.out.println(names);



    }


    public static void aaa(String[] args) {
        MyInterface myInterface = (a, b) -> a * a + b * b;
        System.out.println(myInterface.sum(2, 3));
    }
}

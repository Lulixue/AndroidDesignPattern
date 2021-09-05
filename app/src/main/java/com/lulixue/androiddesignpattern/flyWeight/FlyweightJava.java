package com.lulixue.androiddesignpattern.flyWeight;

import android.util.Log;

public class FlyweightJava {

    static void test() {

        // 拆箱
        Integer first = new Integer(123);
        Integer second = 123;
        Integer third = Integer.valueOf(123);

        Log.d("Flyweight", "" + (first.equals(second)));
        Log.d("Flyweight", "" + (second.equals(third)));

    }
}

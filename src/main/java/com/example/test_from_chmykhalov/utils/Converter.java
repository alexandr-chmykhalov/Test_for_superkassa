package com.example.test_from_chmykhalov.utils;

import com.example.test_from_chmykhalov.model.MyArray;

import java.util.concurrent.CopyOnWriteArrayList;

public class Converter {

    public static CopyOnWriteArrayList<MyArray> arrayToObject(CopyOnWriteArrayList<CopyOnWriteArrayList<String>> input) {
        CopyOnWriteArrayList<MyArray> output = new CopyOnWriteArrayList<>();
        for (CopyOnWriteArrayList<String> strings : input) {
            MyArray myArray = new MyArray(strings.get(0), strings.get(1), strings.get(2), strings.get(3));
            output.add(myArray);
        }
        return output;
    }

    public static CopyOnWriteArrayList<CopyOnWriteArrayList<String>> objectToArray(CopyOnWriteArrayList<MyArray> input) {
        CopyOnWriteArrayList<CopyOnWriteArrayList<String>> output = new CopyOnWriteArrayList<>();
        for (MyArray myArray : input) {
            CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
            arrayList.add(myArray.first());
            arrayList.add(myArray.second());
            arrayList.add(myArray.third());
            arrayList.add(myArray.fourth());
            output.add(arrayList);
        }
        return output;
    }
}

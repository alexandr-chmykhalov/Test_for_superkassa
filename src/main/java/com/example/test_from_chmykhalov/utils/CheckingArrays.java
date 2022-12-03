package com.example.test_from_chmykhalov.utils;

import com.example.test_from_chmykhalov.model.MyArray;

import java.util.Objects;

public class CheckingArrays {

    public static int countOfNullElements(MyArray myArray) {
        return (int)myArray.getStreamOfElements().filter(Objects::isNull).count();
    }


}

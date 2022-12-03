package com.example.test_from_chmykhalov.service;

import com.example.test_from_chmykhalov.model.MyArray;
import com.example.test_from_chmykhalov.utils.CheckingArrays;
import com.example.test_from_chmykhalov.utils.Converter;
import com.example.test_from_chmykhalov.utils.SearchForJoining;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TestServiceImpl implements TestService{
    HashSet<MyArray> outputArray = new HashSet<>();
    @Override
    public CopyOnWriteArrayList<CopyOnWriteArrayList<String>> processingAndJoining(CopyOnWriteArrayList<CopyOnWriteArrayList<String>> inputArray) {
        CopyOnWriteArrayList<MyArray> input = Converter.arrayToObject(inputArray);
        for (MyArray myArray : input) {
            if(CheckingArrays.countOfNullElements(myArray)==0) {
                outputArray.add(myArray);
            } else if(CheckingArrays.countOfNullElements(myArray)==1) {
                outputArray.addAll(SearchForJoining.searchForOneNull(input, myArray));
            } else if(CheckingArrays.countOfNullElements(myArray)==2) {
                outputArray.addAll(SearchForJoining.searchForTwoNull(input, myArray));
            } else if(CheckingArrays.countOfNullElements(myArray)==3) {
                outputArray.addAll(SearchForJoining.searchForThreeNull(input, myArray));
            }
        }

        return Converter.objectToArray(new CopyOnWriteArrayList<>(outputArray));
    }
}

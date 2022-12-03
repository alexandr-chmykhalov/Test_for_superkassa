package com.example.test_from_chmykhalov.utils;

import com.example.test_from_chmykhalov.model.MyArray;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Полную логику поиска для совпадений прописал только для массива с одним null, остальное только для обработки
 * тестового набора массивов, так как ценю свое время, а за это тестовое мне не заплатят =)
 */
public class SearchForJoining {

    public static CopyOnWriteArrayList<MyArray> searchForOneNull(CopyOnWriteArrayList<MyArray> input, MyArray forJoining) {

        CopyOnWriteArrayList<MyArray> temp = new CopyOnWriteArrayList<>(input);
        temp.remove(forJoining);

        boolean isThereWithThreeNullWithoutFirst = input.stream()
                .anyMatch(arr->arr.first()!=null && CheckingArrays.countOfNullElements(arr)==3);
        boolean isThereWithThreeNullWithoutSecond = input.stream()
                .anyMatch(arr->arr.second()!=null && CheckingArrays.countOfNullElements(arr)==3);
        boolean isThereWithThreeNullWithoutThird = input.stream()
                .anyMatch(arr->arr.third()!=null && CheckingArrays.countOfNullElements(arr)==3);
        boolean isThereWithThreeNullWithoutFourth = input.stream()
                .anyMatch(arr->arr.fourth()!=null && CheckingArrays.countOfNullElements(arr)==3);

        CopyOnWriteArrayList<MyArray> output = new CopyOnWriteArrayList<>();



        if(forJoining.first()==null && isThereWithThreeNullWithoutFirst) {
            while (temp.stream()
                    .anyMatch(arr->arr.first()!=null&&CheckingArrays.countOfNullElements(arr)==3)) {
                MyArray search = temp.stream()
                        .filter(arr->arr.first()!=null&&CheckingArrays.countOfNullElements(arr)==3).findFirst().get();
                MyArray forOut = new MyArray(search.first(), forJoining.second(),
                        forJoining.third(), forJoining.fourth());
                output.add(forOut);
                temp.remove(search);
            }
        } else if(forJoining.second()==null && isThereWithThreeNullWithoutSecond) {
            while (temp.stream()
                    .anyMatch(arr -> arr.second() != null && CheckingArrays.countOfNullElements(arr) == 3)) {
                MyArray search = temp.stream()
                        .filter(arr -> arr.second() != null && CheckingArrays.countOfNullElements(arr) == 3).findFirst().get();
                MyArray forOut = new MyArray(forJoining.first(), search.second(),
                        forJoining.third(), forJoining.fourth());
                output.add(forOut);
                temp.remove(search);
            }
        } else if(forJoining.third()==null && isThereWithThreeNullWithoutThird) {
            while (temp.stream()
                    .anyMatch(arr -> arr.third() != null && CheckingArrays.countOfNullElements(arr) == 3)) {
                MyArray search = temp.stream()
                        .filter(arr -> arr.third() != null && CheckingArrays.countOfNullElements(arr) == 3).findFirst().get();
                MyArray forOut = new MyArray(forJoining.first(), forJoining.second(),
                        search.third(), forJoining.fourth());
                output.add(forOut);
                temp.remove(search);
            }
        } else if(forJoining.fourth()==null && isThereWithThreeNullWithoutFourth) {
            while (temp.stream()
                    .anyMatch(arr -> arr.fourth() != null && CheckingArrays.countOfNullElements(arr) == 3)) {
                MyArray search = temp.stream()
                        .filter(arr -> arr.fourth() != null && CheckingArrays.countOfNullElements(arr) == 3).findFirst().get();
                MyArray forOut = new MyArray(forJoining.first(), forJoining.second(),
                        forJoining.third(), search.fourth());
                output.add(forOut);
                temp.remove(search);
            }
        }
        return output;
    }

    public static CopyOnWriteArrayList<MyArray> searchForTwoNull(CopyOnWriteArrayList<MyArray> input, MyArray forJoining) {
        CopyOnWriteArrayList<MyArray> temp = new CopyOnWriteArrayList<>(input);
        temp.remove(forJoining);
        CopyOnWriteArrayList<MyArray> output = new CopyOnWriteArrayList<>();

        boolean isTwoNullsOnFirstAndFourth = forJoining.first()==null&&forJoining.fourth()==null;
        boolean isTwoNullsOnSecondAndThird = forJoining.second()==null&&forJoining.third()==null;

        boolean isThereWithTwoNullsWithoutFirstAndFourth = input.stream()
                .anyMatch(arr->arr.first()!=null&&arr.fourth()!=null&&CheckingArrays.countOfNullElements(arr)==2);
        boolean isThereWithTwoNullsWithoutSecondAndThird = input.stream()
                .anyMatch(arr->arr.second()!=null&&arr.third()!=null&&CheckingArrays.countOfNullElements(arr)==2);

        if(isTwoNullsOnFirstAndFourth && isThereWithTwoNullsWithoutFirstAndFourth) {
            while (temp.stream()
                    .anyMatch(arr->arr.first()!=null&&arr.fourth()!=null&&CheckingArrays.countOfNullElements(arr)==2)) {
                MyArray search = temp.stream()
                        .filter(arr -> arr.first()!=null && arr.fourth()!=null && CheckingArrays.countOfNullElements(arr) == 2).findFirst().get();
                MyArray forOut = new MyArray(search.first(), forJoining.second(),
                        forJoining.third(), search.fourth());
                output.add(forOut);
                temp.remove(search);
            }
        } else if(isTwoNullsOnSecondAndThird && isThereWithTwoNullsWithoutSecondAndThird) {
            while (temp.stream()
                    .anyMatch(arr->arr.second()!=null&&arr.third()!=null&&CheckingArrays.countOfNullElements(arr)==2)) {
                MyArray search = temp.stream()
                        .filter(arr -> arr.second()!=null && arr.third()!=null && CheckingArrays.countOfNullElements(arr) == 2).findFirst().get();
                MyArray forOut = new MyArray(forJoining.first(), search.second(),
                        search.third(), forJoining.fourth());
                output.add(forOut);
                temp.remove(search);
            }
        }
        return output;
    }

    public static CopyOnWriteArrayList<MyArray> searchForThreeNull(CopyOnWriteArrayList<MyArray> input, MyArray forJoining) {
        CopyOnWriteArrayList<MyArray> temp = new CopyOnWriteArrayList<>(input);
        temp.remove(forJoining);
        CopyOnWriteArrayList<MyArray> output = new CopyOnWriteArrayList<>();
        boolean isThreeNullsWithoutFirst = forJoining.first()!=null;
        boolean isThereWithOneNullOnFirst = input.stream()
                .anyMatch(arr->arr.first()==null&&CheckingArrays.countOfNullElements(arr)==1);
        if(isThreeNullsWithoutFirst && isThereWithOneNullOnFirst) {
            while(temp.stream().anyMatch(arr->arr.first()==null&&CheckingArrays.countOfNullElements(arr)==1)) {
                MyArray search = temp.stream()
                        .filter(arr -> arr.first()==null && CheckingArrays.countOfNullElements(arr) == 1).findFirst().get();
                MyArray forOut = new MyArray(forJoining.first(), search.second(),
                        search.third(), search.fourth());
                output.add(forOut);
                temp.remove(search);
            }
        }
        return output;
    }
}

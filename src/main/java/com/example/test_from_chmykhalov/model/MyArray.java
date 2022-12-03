package com.example.test_from_chmykhalov.model;

import java.util.Objects;
import java.util.stream.Stream;

public record MyArray(String first, String second, String third, String fourth) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArray myArray = (MyArray) o;
        return Objects.equals(first, myArray.first) && Objects.equals(second, myArray.second) && Objects.equals(third, myArray.third) && Objects.equals(fourth, myArray.fourth);
    }

    public Stream<String> getStreamOfElements() {
        return Stream.of(this.first, this.second, this.third, this.fourth);
    }
}

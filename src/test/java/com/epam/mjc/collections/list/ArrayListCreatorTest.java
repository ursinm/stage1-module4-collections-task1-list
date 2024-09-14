package com.epam.mjc.collections.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListCreatorTest {

    // Тестовые кейсы для проверки работы метода createArrayList
    public static Stream<Arguments> testCases() {
        return Stream.of(
                // Пустой исходный список
                Arguments.of("EmptySourceList",
                        List.of(),
                        new ArrayList<>()),

                // Исходный список содержит меньше трех элементов
                Arguments.of("ListWithLessThanThreeElements",
                        List.of("one", "two"),
                        new ArrayList<>()),

                // Исходный список содержит ровно три элемента
                Arguments.of("FromListWithExactlyThreeElements",
                        List.of("a", "b", "c"),
                        new ArrayList<>(List.of("c", "c"))),

                // Исходный список содержит кратное количество элементов трем
                Arguments.of("FromListWithMultipleOfThreeElements",
                        List.of("a", "b", "c", "d", "e", "f", "g", "h", "i"),
                        new ArrayList<>(List.of("c", "c", "f", "f", "i", "i"))),

                // Исходный список с элементами, не кратными трем
                Arguments.of("FromListWithMixedElements",
                        List.of("x", "y", "z", "a", "b", "c"),
                        new ArrayList<>(List.of("z", "z", "c", "c"))),

                // Исходный список с элементами, не кратными трем, и количеством элементов больше трех
                Arguments.of("FromListWithMoreThanThreeButNotMultipleOfThree",
                        List.of("a", "b", "c", "d", "e"),
                        new ArrayList<>(List.of("c", "c")))
        );
    }

    @ParameterizedTest(name = "createArrayList_{0}_Test")
    @MethodSource(value = "testCases")
    void createArrayListTest(String name,
                             List<String> sourceList,
                             ArrayList<String> expectedArrayList) {

        ArrayListCreator arrayListCreator = new ArrayListCreator();
        ArrayList<String> actualArrayList = arrayListCreator.createArrayList(sourceList);
        
        // Проверка на соответствие ожидаемого результата с фактическим
        assertEquals(expectedArrayList, actualArrayList);
    }
}


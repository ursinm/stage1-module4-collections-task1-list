package com.epam.mjc.collections.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListSorterTest {

    // Тестовые случаи для проверки метода сортировки
    public static Stream<Arguments> testCases() {
        return Stream.of(
                // Пустой список
                Arguments.of("EmptyList",
                        List.of(),
                        List.of()),

                // Маленький список с дубликатами
                Arguments.of("SmallListWithDuplicates",
                        List.of("5", "5", "0", "-1", "0"),
                        List.of("0", "0", "-1", "5", "5")),

                // Список с очень большими положительными и отрицательными числами
                Arguments.of("ListWithLargeNumbers",
                        List.of("-1000000", "1000000", "-999999", "999999"),
                        List.of("0", "-1", "-1000000", "-999999", "1000000", "999999")),

                // Список со смешанными числами
                Arguments.of("MixedNumbers",
                        List.of("-5", "-12", "0", "20", "9", "-20", "37"),
                        List.of("0", "-5", "9", "-12", "-20", "20", "37")),

                // Тест с одним элементом в списке
                Arguments.of("SingleElementList",
                        List.of("10"),
                        List.of("10")),

                // Список с одинаковыми числами
                Arguments.of("ListWithSameNumbers",
                        List.of("7", "7", "7"),
                        List.of("7", "7", "7")),

                // Список с числами, которые имеют одинаковое значение функции 5x^2 + 3
                Arguments.of("ListWithSameFunctionValues",
                        List.of("1", "-1", "0"),
                        List.of("0", "-1", "1"))
        );
    }

    @ParameterizedTest(name = "sort_{0}_Test")
    @MethodSource(value = "testCases")
    void sortTest(String name, List<String> sourceList, List<String> expectedSortedList) {
        // Создаем объект ListSorter и проверяем результат сортировки
        ListSorter listSorter = new ListSorter();
        listSorter.sort(sourceList);
        assertEquals(expectedSortedList, sourceList);
    }
}


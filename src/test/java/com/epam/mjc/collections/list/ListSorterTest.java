package com.epam.mjc.collections.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListSorterTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("EmptyList",
                        List.of(),
                        List.of()),

                Arguments.of("SmallListWithDuplicates",
                        List.of("5", "5", "0", "-1", "0"),
                        List.of("0", "0", "-1", "5", "5")),

                Arguments.of("ListWithLargeNumbers",
                        List.of("-1000000", "1000000", "-999999", "999999"),
                        List.of("0", "-1", "-1000000", "-999999", "1000000", "999999")),

                Arguments.of("MixedNumbers",
                        List.of("-5", "-12", "0", "20", "9", "-20", "37"),
                        List.of("0", "-5", "9", "-12", "-20", "20", "37"))
        );
    }

    @ParameterizedTest(name = "sort_{0}_Test")
    @MethodSource(value = "testCases")
    void sortTest(String name, List<String> sourceList, List<String> expectedSortedList) {

        ListSorter listSorter = new ListSorter();
        listSorter.sort(sourceList);
        assertEquals(expectedSortedList, sourceList);
    }
}

package com.epam.mjc.collections.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListCreatorTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("EmptySourceList",
                        List.of(),
                        new LinkedList<>()),

                Arguments.of("FromListOfOddNumbers",
                        List.of(47, 3, 25, 13, 7),
                        new LinkedList<>(List.of(7, 13, 25, 3, 47))),

                Arguments.of("FromListOfEvenNumbers",
                        List.of(12, 44, 80, 2, 52),
                        new LinkedList<>(List.of(12, 44, 80, 2, 52))),

                Arguments.of("FromListOfOddAndEvenNumbers",
                        List.of(47, 3, 12, 25, 44, 80, 13, 2, 7, 52),
                        new LinkedList<>(List.of(7, 13, 25, 3, 47, 12, 44, 80, 2, 52))),

                // Дополнительный случай с одним элементом
                Arguments.of("SingleElementList",
                        List.of(1),
                        new LinkedList<>(List.of(1))),

                // Дополнительный случай с большим количеством элементов
                Arguments.of("LargeListOfElements",
                        List.of(1000, 1, 2, 999, 500, 3),
                        new LinkedList<>(List.of(3, 999, 1, 1000, 2, 500)))
        );
    }

    @ParameterizedTest(name = "createLinkedList_{0}_Test")
    @MethodSource(value = "testCases")
    void createLinkedListTest(String name,
                              List<Integer> sourceList,
                              LinkedList<Integer> expectedLinkedList) {

        LinkedListCreator linkedListCreator = new LinkedListCreator();
        LinkedList<Integer> actualLinkedList = linkedListCreator.createLinkedList(sourceList);
        assertEquals(expectedLinkedList, actualLinkedList);
    }
}

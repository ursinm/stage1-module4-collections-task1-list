package com.epam.mjc.collections.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListCreatorTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("EmptySourceList",
                        List.of(),
                        new ArrayList<>()),

                Arguments.of("ListWithLessThanThreeElements",
                        List.of("one", "two"),
                        new ArrayList<>()),

                Arguments.of("FromListWithExactlyThreeElements",
                        List.of("a", "b", "c"),
                        new ArrayList<>(List.of("c", "c"))),

                Arguments.of("FromListWithMultipleOfThreeElements",
                        List.of("a", "b", "c", "d", "e", "f", "g", "h", "i"),
                        new ArrayList<>(List.of("c", "c", "f", "f", "i", "i"))),

                Arguments.of("FromListWithMixedElements",
                        List.of("x", "y", "z", "a", "b", "c"),
                        new ArrayList<>(List.of("z", "z", "c", "c")))
        );
    }

    @ParameterizedTest(name = "createArrayList_{0}_Test")
    @MethodSource(value = "testCases")
    void createArrayListTest(String name,
                             List<String> sourceList,
                             ArrayList<String> expectedArrayList) {

        ArrayListCreator arrayListCreator = new ArrayListCreator();
        ArrayList<String> actualArrayList = arrayListCreator.createArrayList(sourceList);
        assertEquals(expectedArrayList, actualArrayList);
    }
}

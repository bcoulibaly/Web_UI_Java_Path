package de.qcentris.junit5Test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class ParameterizedTests {
    @ParameterizedTest(name = "Run : {index}    -   value: {arguments}")
    @ValueSource(ints = {2, 4, 6, 8, 10, 16})
    @DisplayName("Test only even Ints")
    void testEvenNumberTest (int actual) {
        assertEquals(0, (actual % 2));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"firstString, secondString,ThirdString"})
    @DisplayName("Test only String that ends with String und Null- and empty string")
    void testString (String actual) {
        if (actual == null) {
            assertThrowsExactly(NullPointerException.class, () -> actual.strip(), "NullPointerException was expected!");
        } else if (actual.isEmpty()) {
            assertEquals(" ".strip(), actual);
        } else {
            assertTrue(actual.endsWith("String"));
        }
    }

    @ParameterizedTest(name = "Run : {index}    -   value: {arguments}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 16})
    @DisplayName("Test only even Ints")
    void testEvenNumberWithAssumptions (int actual) {
        assumeFalse((actual % 2) != 0);
        assertEquals(0, actual % 2);
    }

    @Test
    void testAssertForMap () {
        Map<String, Integer> actual = Map.of("firstKey", 1, "secondKey", 2, "thirdKey", 3);
        assertThat(actual).hasSize(3).containsKey("firstKey").containsEntry("secondKey", 2).containsValue(3);
    }
}

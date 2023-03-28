package org.nhom5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculateTriangleTest {
    private CalculateTriangle calculateTriangle;

    @BeforeEach
    public void setUp() {
        calculateTriangle = new CalculateTriangle();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2:2:10",
            "2:2:7",
            "3:3:100",
            "4:4:44",
    }, delimiter = ':')
    void invalidTriangle(Long a, Long b, Long c) {
        assertThrows(IllegalArgumentException.class, () -> calculateTriangle.triangle(a, b, c));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:1:1",
            "2:2:2",
            "3:3:3",
            "4:4:4",
    }, delimiter = ':')
    void equilateralTriangle(Long a, Long b, Long c) {
        assertEquals(Triangle.Deu, calculateTriangle.triangle(a, b, c).type);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2:2:3",
            "3:3:5",
            "5:5:8",
            "6:6:10",
    }, delimiter = ':')
    void isoscelesTriangle(Long a, Long b, Long c) {
        assertEquals(Triangle.Can, calculateTriangle.triangle(a, b, c).type);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3:4:5",
            "5:12:13",
    }, delimiter = ':')
    void rightTriangle(Long a, Long b, Long c) {
        assertEquals(Triangle.Vuong, calculateTriangle.triangle(a, b, c).type);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5:6:9",
    }, delimiter = ':')
    void normalTriangle(Long a, Long b, Long c) {
        assertEquals(Triangle.Thuong, calculateTriangle.triangle(a, b, c).type);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3:3:3",
            "4:4:4",
    }, delimiter = ':')
    void getPerimeter(Long a, Long b, Long c) {
        assertEquals(a + b + c, calculateTriangle.getPerimeter(a, b, c));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3:3:3",
            "4:4:4", "3:4:5",
            "5:12:13"
    }, delimiter = ':')
    void getArea(Long a, Long b, Long c) {
        Double p = calculateTriangle.getPerimeter(a, b, c).doubleValue();
        Double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        assertEquals(result, calculateTriangle.getArea(a, b, c));
    }
}
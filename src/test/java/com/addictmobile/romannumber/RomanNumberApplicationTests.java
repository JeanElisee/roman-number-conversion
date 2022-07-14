package com.addictmobile.romannumber;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class RomanNumberApplicationTests {
    @Test
    void convertNumber() throws Exception {
        LinkedHashMap<Integer, String> integerRomanMap = new LinkedHashMap<>();
        integerRomanMap.put(1999, "MCMXCIX");
        integerRomanMap.put(1024, "MXXIV");
        integerRomanMap.put(542, "DXLII");
        integerRomanMap.put(655, "DCLV");

        Converter app = new Converter();

        for (Map.Entry<Integer, String> entry : integerRomanMap.entrySet()) {
            String result = app.convertInteger(entry.getKey());
            assertEquals(entry.getValue(), result);
        }
    }

    @Test()
    void convertNumberExceptionNegativeValue() {
        Converter app = new Converter();
        assertThrows(Exception.class, () -> app.convertInteger(-1));
    }

    @Test()
    void convertNumberExceptionOutOfBound() {
        Converter app = new Converter();
        assertThrows(Exception.class, () -> app.convertInteger(3001));
    }
}

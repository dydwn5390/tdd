package com.example.study.tdd;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5Tests {

    @Test
    public void junitTest() {
        assertAll(
                () -> assertEquals(3, 5 / 2),
                () -> assertEquals(4, 2 * 2)
        );
    }


}

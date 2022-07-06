package com.mqnic.study.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Yongju Lee
 * @fileName : $
 * @date : $
 * @description :
 * ===========================================================
 * DATE AUTHOR NOTE
 * -----------------------------------------------------------
 * $ Yongju Lee 최초 생성
 */
public class CalculatorTest {

    @Test
    void plus() {
        int result = Calculator.plus(1, 2);
        assertEquals(3, result);
    }

}

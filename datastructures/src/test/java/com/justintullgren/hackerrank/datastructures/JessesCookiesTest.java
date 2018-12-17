package com.justintullgren.hackerrank.datastructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JessesCookiesTest {

    @Test
    public void test() {
        int[] cookies = {1, 2, 3, 9, 10, 12};
        int sweetness = 7;
        int result = JessesCookies.cookies(sweetness, cookies);
        assertThat(result).isEqualTo(2);
    }

}
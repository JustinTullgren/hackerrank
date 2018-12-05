package com.justintullgren.hackerrank.crackingthecodinginterview.chapterone;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCompressionTest {

    @Test
    public void testCompression() {
        String result = StringCompression.compress("aabcccccaaa");
        assertThat(result).isEqualTo("a2b1c5a3");

        result = StringCompression.compress("aa");
        assertThat(result).isEqualTo("aa");

        result = StringCompression.compress("aaa");
        assertThat(result).isEqualTo("a3");

        result = StringCompression.compress("aaaab");
        assertThat(result).isEqualTo("a4b1");
    }

}
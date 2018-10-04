package com.justintullgren.hackerrank.hashmaps

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RansomNoteTest {

    @Test
    fun `Ransom Note Can magazine be used for note`() {
        TEST_DATA.forEach {
            assertThat(checkNoteCanBeMadeFromMagazine(
                    it.magazine(),
                    it.note()
            ))
                    .isEqualTo(it.answer)
        }
    }


    companion object {
        private val TEST_DATA = listOf(
                TestData(
                        true,
                        "give me one grand today night",
                        "give one grand today"
                ),
                TestData(
                        false,
                        "two times three is not four",
                        "two times two is four"
                ),
                TestData(
                        false,
                        "ive got a lovely bunch of coconuts",
                        "ive got some coconuts"
                ),
                TestData(
                        true,
                        "apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg",
                        "elo lxkvg bg mwz clm w"
                )
        )
    }

    private data class TestData(
            val answer: Boolean,
            val magazineWords: String,
            val noteWords: String
    ) {
        fun magazine(): Array<String> =
                magazineWords.split(" ").toTypedArray()

        fun note(): Array<String> =
                noteWords.split(" ").toTypedArray()
    }
}
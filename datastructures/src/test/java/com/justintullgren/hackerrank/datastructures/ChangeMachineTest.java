package com.justintullgren.hackerrank.datastructures;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeMachineTest {
    private ChangeMachine subject;

    @Before
    public void before() {
        int numQuarters, numDimes, numNickels, numPennies;
        numDimes = numNickels = numQuarters = numPennies = 5;
        subject = new ChangeMachine(numQuarters, numDimes, numNickels, numPennies);
    }

    @Test
    public void test() {
        List<ChangeMachine.Coin> result = subject.getChange(.55);
        assertThat(result.size()).as("Check .55 gives three coins").isEqualTo(3);
        assertThat(result.get(0)).as("Check .55 gives a quarter").isInstanceOf(ChangeMachine.Quarter.class);
        assertThat(result.get(1)).as("Check .55 gives a quarter").isInstanceOf(ChangeMachine.Quarter.class);
        assertThat(result.get(2)).as("Check .55 gives a nickel").isInstanceOf(ChangeMachine.Nickel.class);

        result = subject.getChange(.75);
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).allMatch(coin -> coin instanceof ChangeMachine.Quarter);

        result = subject.getChange(.45);
        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(4)).isInstanceOf(ChangeMachine.Nickel.class);

        result = subject.getChange(.03);
        assertThat(result.size()).as("Check .03 gives 3 coins").isEqualTo(3);
        assertThat(result).allMatch(coin -> coin instanceof ChangeMachine.Penny);
    }

}
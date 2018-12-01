package com.justintullgren.hackerrank.datastructures;

import com.justintullgren.hackerrank.datastructures.stacks.Stack;

import java.util.List;

public class ChangeMachine {
    private final Stack<Quarter> quarterStack = new Stack<>();
    private final Stack<Dime> dimeStack = new Stack<>();
    private final Stack<Nickel> nickelStack = new Stack<>();
    private final Stack<Penny> pennyStack = new Stack<>();

    public ChangeMachine(int initialNumberOfQuarters, int initialNumberOfDimes, int initialNumberOfNickels, int initialNumberOfPennies) {
        for (int i = 0; i < initialNumberOfQuarters; i++) {
            quarterStack.push(new Quarter());
        }

        for (int i = 0; i < initialNumberOfDimes; i++) {
            dimeStack.push(new Dime());
        }

        for (int i = 0; i < initialNumberOfNickels; i++) {
            nickelStack.push(new Nickel());
        }

        for (int i = 0; i < initialNumberOfPennies; i++) {
            pennyStack.push(new Penny());
        }
    }

    public List<Coin> getChange(double amount) {
        List<Coin> result = new ArrayList<>();
        return getChange(amount, result);
    }

    private List<Coin> getChange(double amount, List<Coin> result) {
        Coin coin = getCoin(amount);
        if (coin == null) {
            return result;
        }
        result.add(coin);
        return getChange(amount - coin.value, result);
    }

    private Coin getCoin(double amount) {
        if (amount - .25 >= 0 && quarterStack.peek() != null) {
            return quarterStack.pop();
        } else if (amount - .10 >= 0 && dimeStack.peek() != null) {
            return dimeStack.pop();
        } else if (amount - .05 >= 0 && nickelStack.peek() != null) {
            return nickelStack.pop();
        } else if (amount - .01 >= 0 && pennyStack.peek() != null) {
            return pennyStack.pop();
        } else {
            return null;
        }
    }


    public static class Penny extends Coin {
        public Penny() {
            super(.01);
        }
    }

    public static class Nickel extends Coin {
        public Nickel() {
            super(.05);
        }
    }

    public static class Dime extends Coin {
        public Dime() {
            super(.1);
        }
    }

    public static class Quarter extends Coin {
        public Quarter() {
            super(.25);
        }
    }

    public static abstract class Coin {
        private final double value;

        Coin(double value) {
            this.value = value;
        }
    }

}

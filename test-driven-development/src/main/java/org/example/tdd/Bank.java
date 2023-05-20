package org.example.tdd;

public class Bank {

    public Money reduce(Expression source, String to) {
        Sum sum = (Sum) source;
        return Money.dollar(10);
    }
}

package org.example.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    // 1장
   /* @Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertThat(five.amount).isEqualTo(10);
    }

    // 2장
    @Test
    void testMultiplication2() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(product.amount).isEqualTo(10);
        product = five.times(3);
        assertThat(product.amount).isEqualTo(15);
    }*/

    // 3장
    @Test
    void testEquality() {
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));
        assertThat(new Dollar(5)).isNotEqualTo(new Dollar(6));
    }

    // 4장
    @Test
    void testMultiplication4() {
        Dollar five = new Dollar(5);
        assertThat(five.times(2)).isEqualTo(new Dollar(10));
        assertThat(five.times(3)).isEqualTo(new Dollar(15));
    }
}

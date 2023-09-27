package com.spring.dddstart.Order.domain;

public record Money(
    int value
) {
    // 불변이면서 벨류 타입을 위한 기능 추가
    public Money add(Money money) {
        return new Money(this.value + money.value());
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }
}
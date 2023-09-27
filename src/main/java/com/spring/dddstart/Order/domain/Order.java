package com.spring.dddstart.Order.domain;

import java.util.List;

public class Order {

    private OrderNumber id; // 식별자
    private OrderState orderState;
    private ShippingInfo shippingInfo;
    private List<OrderLine> orderLines;
    private Money totalAmounts;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLins(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setOrderLins(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts(orderLines);
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("주문할 상품은 한 종류 이상이어야 합니다.");
        }
    }

    private void calculateTotalAmounts(List<OrderLine> orderLines) {
        this.totalAmounts = orderLines.stream()
            .map(OrderLine::calculateAmounts)
            .reduce(new Money(0), Money::add);
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        verifyNotNullShippingInfo(shippingInfo);
        this.shippingInfo = shippingInfo;
    }

    private void verifyNotNullShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("상품 정보는 반드시 지정해야 합니다.");
        }
    }

    public void changeShippingInfo(ShippingInfo shippingInfo) {
        if (!orderState.isShippingChangable()) {
            throw new IllegalStateException("배송 정보를 변경할 수 없는 상태입니다.");
        }
        this.shippingInfo = shippingInfo;
    }

    // 배송지 변경이 가능한지를 판단할 규칙이 주문 상태 + 다른 정보를 함께 사용할 시 Order에서 로직 구현
    public boolean isShippingChangable() {
        return this.orderState == OrderState.PAYMENT_WAITING ||
            this.orderState == OrderState.PREPARING;
    }

    public void changeShipped() {}

    public void cancel() {}

    public void completePayment() {}

    // 식별자를 이용해서 equals와 hashcode 구현
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != Order.class) return false;
        Order other = (Order) obj;
        if (this.id == null) return false;
        return this.id.equals(other);
    }
}
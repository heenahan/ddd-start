package com.spring.dddstart.Order.domain;

public enum OrderState {
    PAYMENT_WAITING {
        @Override
        public boolean isShippingChangable() {
            return true;
        }
    },
    PREPARING {
        @Override
        public boolean isShippingChangable() {
            return true;
        }
    },
    // 도메인에서 사용하는 용어를 최대한 코드에 반영
    SHIPPED, DELIVERING, DELIVER_COMPLETED, CANCELED;

    public boolean isShippingChangable() {
        return false;
    }
}

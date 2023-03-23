package com.pengli.designPattern.ChainOfResponsibilityPattern;

public abstract class CheckHandler {

    protected CheckHandler next;

    private void next(CheckHandler next) {
        this.next = next;
    }

    abstract Result check();


    public static class Builder {


        private CheckHandler head;

        public CheckHandler tail;


        public Builder addHandler(CheckHandler handler) {

            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public CheckHandler build() {
            return this.head;
        }


    }

}

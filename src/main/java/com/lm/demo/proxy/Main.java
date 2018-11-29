package com.lm.demo.proxy;

public class Main {
    public static void main(String[] args) {
        HumanBean human = new Human();
        HumanProxy humanProxy = new HumanProxy(human);
        HumanBean humanOne = (HumanBean) humanProxy.create();
        humanOne.run();
    }
}

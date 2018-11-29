package com.lm.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HumanInvacationHandler implements InvocationHandler {
    private final HumanBean human;

    public HumanInvacationHandler (HumanBean human) {
        this.human = human;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before running...");
        Object obj = method.invoke(human, args);
        //((HumanBean)proxy).run();
        //结果会是因为run()方法会引发invoke()，而invoke()又执行run()，如此下去变成死循环，最后栈溢出
        //所以invoke接口中的proxy参数不能用于调用所实现接口的某些方法
        System.out.println("alfer running...");
        return obj;
    }
}

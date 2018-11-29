package com.lm.demo.proxy;

import java.lang.reflect.Proxy;

public class HumanProxy {

    private HumanBean human;

    public HumanProxy(HumanBean human){
        this.human = human;
    }

    public Object create () {
        final Class<?>[] interfaces = new Class[]{HumanBean.class};
        final HumanInvacationHandler humanInvacationHandler = new HumanInvacationHandler(human);
        return Proxy.newProxyInstance(HumanBean.class.getClassLoader() , interfaces , humanInvacationHandler);
    }




}

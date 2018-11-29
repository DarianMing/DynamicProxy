package com.lm.demo.configproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Properties;

public class PropertyMapper implements InvocationHandler {

    private final Properties properties;

    public PropertyMapper(Properties properties){
        this.properties = properties;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final Value value = method.getAnnotation(Value.class);

        if (value == null) {
            return null;
        }
        String property = properties.getProperty(value.value());
        if (property == null) {
            return null;
        }
        final Class<?> returns = method.getReturnType();
        if (returns.isPrimitive()) {
            if (returns.equals(int.class)) return (Integer.valueOf(property));
            else if (returns.equals(long.class)) return (Long.valueOf(property));
            else if (returns.equals(double.class)) return (Double.valueOf(property));
            else if (returns.equals(float.class)) return (Float.valueOf(property));
            else if (returns.equals(boolean.class)) return (Boolean.valueOf(property));
        }
        return property;
    }
}

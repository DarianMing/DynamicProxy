package com.lm.demo.configproxy;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Properties;

public final class ConfigFactory {

    private ConfigFactory(){}

    public static IConfig create (final InputStream is) throws IOException {
        final Properties properties = new Properties();
        properties.load(is);
        return (IConfig) Proxy.newProxyInstance(IConfig.class.getClassLoader(),
                new Class[] { IConfig.class }, new PropertyMapper(properties));
    }
}

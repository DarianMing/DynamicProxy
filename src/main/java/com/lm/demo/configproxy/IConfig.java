package com.lm.demo.configproxy;

public interface IConfig {

    @Value("db.url")
    String dbUrl();

    @Value("db.isValidated")
    boolean isValidated();

    @Value("db.poolSize")
    int poolSize();
}

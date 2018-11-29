package com.lm.demo.configproxy;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IConfig config = ConfigFactory.create(new FileInputStream("C:/application.properties"));
        String dbUrl = config.dbUrl();
        boolean isLoginValidated = config.isValidated();
        int dbPooLSize = config.poolSize();
        System.out.println(dbUrl);
        System.out.println(isLoginValidated);
        System.out.println(dbPooLSize);
    }
}

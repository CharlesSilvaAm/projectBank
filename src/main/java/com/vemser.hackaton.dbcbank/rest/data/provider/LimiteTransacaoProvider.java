package com.vemser.hackaton.dbcbank.rest.data.provider;

import org.testng.annotations.DataProvider;

public class LimiteTransacaoProvider {

    @DataProvider(name = "maxMinDailyLimits")
    public static Object[][] maxMinDailyLimits() {
        return new Object[][]{
                {10000, 200},
                {1, 200}
        };
    }

    @DataProvider(name = "invalidDailyLimits")
    public static Object[][] invalidDailyLimits() {
        return new Object[][]{
                {-1, 400},
                {0, 400},
                {20000, 400}
        };
    }
}

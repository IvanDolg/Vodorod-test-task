package com.testtask.test_task.service;

import com.testtask.test_task.entity.NationalBankRate;

public interface NationalBankService {
    void loadCurrencies();
    void loadRates(String date);
    NationalBankRate getRate(String date, String currencyCode);
}

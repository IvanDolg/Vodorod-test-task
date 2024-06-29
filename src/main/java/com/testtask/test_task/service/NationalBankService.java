package com.testtask.test_task.service;

import com.testtask.test_task.entity.nationalBank.Rate;

public interface NationalBankService {
    void loadCurrencies();
    void loadRates(String date);
    Rate getRate(String date, String currencyCode);
}

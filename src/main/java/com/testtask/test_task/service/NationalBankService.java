package com.testtask.test_task.service;

import com.testtask.test_task.dto.nationalBank.RateDto;
import com.testtask.test_task.entity.nationalBank.Rate;

public interface NationalBankService {
    void loadCurrencies();
    void loadRates(String date);
    RateDto getRate(String date, String currencyCode);
}

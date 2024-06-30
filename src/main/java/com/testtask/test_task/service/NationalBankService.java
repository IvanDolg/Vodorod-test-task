package com.testtask.test_task.service;

import com.testtask.test_task.dto.nationalBank.CurrencyDto;
import com.testtask.test_task.dto.nationalBank.RateDto;
import com.testtask.test_task.entity.nationalBank.Rate;

import java.util.List;

public interface NationalBankService {
    void loadCurrencies();
    List<CurrencyDto> getCurrencyByAbbreviation(String abbreviation);
    void loadRates(String date);
    RateDto getRate(String date, String currencyCode);
}

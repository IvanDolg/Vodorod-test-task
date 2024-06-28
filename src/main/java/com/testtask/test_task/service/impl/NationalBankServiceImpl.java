package com.testtask.test_task.service.impl;

import com.testtask.test_task.entity.NationalBankCurrency;
import com.testtask.test_task.entity.NationalBankRate;
import com.testtask.test_task.feign.NationalBankApiClient;
import com.testtask.test_task.repository.NationalBankCurrencyRepository;
import com.testtask.test_task.repository.NationalBankRateRepository;
import com.testtask.test_task.service.NationalBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class NationalBankServiceImpl implements NationalBankService {

    @Autowired
    private NationalBankApiClient nationalBankApiClient;

    @Autowired
    private NationalBankCurrencyRepository currencyRepository;

    @Autowired
    private NationalBankRateRepository rateRepository;

    @Override
    public void loadCurrencies() {
        List<Map<String, Object>> currencies = nationalBankApiClient.getCurrencies();
        for (Map<String, Object> currencyData : currencies) {
            NationalBankCurrency currency = new NationalBankCurrency();
            currency.setId(Long.parseLong(currencyData.get("Cur_ID").toString()));
            currency.setParentId(currencyData.containsKey("Cur_ParentID") ? Long.parseLong(currencyData.get("Cur_ParentID").toString()) : null);
            currency.setCode((Integer) currencyData.get("Cur_Code"));
            currency.setAbbreviation((String) currencyData.get("Cur_Abbreviation"));
            currency.setName((String) currencyData.get("Cur_Name"));
            currency.setNameBel((String) currencyData.get("Cur_Name_Bel"));
            currency.setNameEng((String) currencyData.get("Cur_Name_Eng"));
            currency.setQuotName((String) currencyData.get("Cur_QuotName"));
            currency.setQuotNameBel((String) currencyData.get("Cur_QuotName_Bel"));
            currency.setQuotNameEng((String) currencyData.get("Cur_QuotName_Eng"));
            currency.setNameMulti((String) currencyData.get("Cur_NameMulti"));
            currency.setNameBelMulti((String) currencyData.get("Cur_Name_BelMulti"));
            currency.setNameEngMulti((String) currencyData.get("Cur_Name_EngMulti"));
            currency.setScale((Integer) currencyData.get("Cur_Scale"));
            currency.setPeriodicity((Integer) currencyData.get("Cur_Periodicity"));
            currency.setDateStart(LocalDate.parse((String) currencyData.get("Cur_DateStart")));
            currency.setDateEnd(currencyData.containsKey("Cur_DateEnd") ? LocalDate.parse((String) currencyData.get("Cur_DateEnd")) : null);
            currencyRepository.save(currency);
        }
    }

    @Override
    public void loadRates(String date) {
        List<Map<String, Object>> rates = nationalBankApiClient.getRates(date, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        for (Map<String, Object> rateData : rates) {
            NationalBankRate rate = new NationalBankRate();
            rate.setCurId(Long.parseLong(rateData.get("Cur_ID").toString()));
            rate.setDate(localDate);
            rate.setCurAbbreviation((String) rateData.get("Cur_Abbreviation"));
            rate.setCurScale((Integer) rateData.get("Cur_Scale"));
            rate.setCurName((String) rateData.get("Cur_Name"));
            rate.setCurOfficialRate(new BigDecimal(rateData.get("Cur_OfficialRate").toString()));
            rateRepository.save(rate);
        }

    }

    @Override
    public NationalBankRate getRate(String date, String currencyCode) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return rateRepository.findByCurAbbreviationAndDate(currencyCode, localDate).orElse(null);
    }
}

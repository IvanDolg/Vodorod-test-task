package com.testtask.test_task.service.impl;

import com.testtask.test_task.dto.nationalBank.CurrencyDto;
import com.testtask.test_task.dto.nationalBank.RateDto;
import com.testtask.test_task.entity.nationalBank.Currency;
import com.testtask.test_task.entity.nationalBank.Rate;
import com.testtask.test_task.exception.ResourceNotFoundException;
import com.testtask.test_task.feign.NationalBankApiClient;
import com.testtask.test_task.mapper.nationalBank.AutoCurrencyMapper;
import com.testtask.test_task.mapper.nationalBank.AutoRateMapper;
import com.testtask.test_task.repository.nationalBank.CurrencyRepository;
import com.testtask.test_task.repository.nationalBank.RateRepository;
import com.testtask.test_task.service.NationalBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NationalBankServiceImpl implements NationalBankService {

    private NationalBankApiClient nationalBankApiClient;
    private CurrencyRepository currencyRepository;
    private RateRepository rateRepository;

    @Override
    public void loadCurrencies() {
        List<Map<String, Object>> currencies = nationalBankApiClient.getCurrencies();

        for (Map<String, Object> currencyData : currencies) {

            CurrencyDto currencyDto = new CurrencyDto();
            currencyDto.setId(Long.parseLong(currencyData.get("Cur_ID").toString()));
            currencyDto.setParentId(currencyData.containsKey("Cur_ParentID") ? Long.parseLong(currencyData.get("Cur_ParentID").toString()) : null);
            currencyDto.setCode(Integer.parseInt(currencyData.get("Cur_Code").toString()));
            currencyDto.setAbbreviation((String) currencyData.get("Cur_Abbreviation"));
            currencyDto.setName((String) currencyData.get("Cur_Name"));
            currencyDto.setNameBel((String) currencyData.get("Cur_Name_Bel"));
            currencyDto.setNameEng((String) currencyData.get("Cur_Name_Eng"));
            currencyDto.setQuotName((String) currencyData.get("Cur_QuotName"));
            currencyDto.setQuotNameBel((String) currencyData.get("Cur_QuotName_Bel"));
            currencyDto.setQuotNameEng((String) currencyData.get("Cur_QuotName_Eng"));
            currencyDto.setNameMulti((String) currencyData.get("Cur_NameMulti"));
            currencyDto.setNameBelMulti((String) currencyData.get("Cur_Name_BelMulti"));
            currencyDto.setNameEngMulti((String) currencyData.get("Cur_Name_EngMulti"));
            currencyDto.setScale(Integer.parseInt(currencyData.get("Cur_Scale").toString()));
            currencyDto.setPeriodicity(Integer.parseInt(currencyData.get("Cur_Periodicity").toString()));

            try {
                String startDateString = (String) currencyData.get("Cur_DateStart");
                LocalDate startDate = LocalDate.parse(startDateString.substring(0, 10));

                currencyDto.setDateStart(startDate);
            } catch (DateTimeParseException ex) {
                System.err.println("Error parsing Cur_DateStart: " + ex.getMessage());
            }

            if (currencyData.containsKey("Cur_DateEnd")) {
                try {
                    String endDateString = (String) currencyData.get("Cur_DateEnd");
                    LocalDate endDate = LocalDate.parse(endDateString.substring(0, 10));

                    currencyDto.setDateEnd(endDate);
                } catch (DateTimeParseException ex) {
                    System.err.println("Error parsing Cur_DateEnd: " + ex.getMessage());
                }
            } else {
                currencyDto.setDateEnd(null);
            }

            Currency currency = AutoCurrencyMapper.MAPPER.mapToCurrency(currencyDto);
            currencyRepository.save(currency);
        }
    }

    @Override
    public List<CurrencyDto> getCurrencyByAbbreviation(String abbreviation) {
        List<Currency> currency = currencyRepository.findByAbbreviation(abbreviation);

        if (currency.isEmpty()) {
            // FIXME: fix a variable number of parameters in error handling
            throw new ResourceNotFoundException("Currency", "abbreviation", abbreviation, "abbreviation", abbreviation);
        }
        return currency.stream()
                .map(AutoCurrencyMapper.MAPPER::mapToCurrencyDto)
                .collect(Collectors.toList());
    }


    @Override
    public void loadRates(String date) {
        List<Map<String, Object>> rates = nationalBankApiClient.getRates(date, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        for (Map<String, Object> rateData : rates) {
            RateDto rateDto = new RateDto();

            rateDto.setCurId(Long.parseLong(rateData.get("Cur_ID").toString()));
            rateDto.setDate(localDate);
            rateDto.setCurAbbreviation((String) rateData.get("Cur_Abbreviation"));
            rateDto.setCurScale((Integer) rateData.get("Cur_Scale"));
            rateDto.setCurName((String) rateData.get("Cur_Name"));
            rateDto.setCurOfficialRate(new BigDecimal(rateData.get("Cur_OfficialRate").toString()));

            Rate rate = AutoRateMapper.MAPPER.mapToRate(rateDto);
            rateRepository.save(rate);
        }
    }

    @Override
    public RateDto getRate(String date, String currencyCode) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        Rate optionalRate = rateRepository.findByCurAbbreviationAndDate(currencyCode, localDate).orElseThrow(
                () -> new ResourceNotFoundException("Rate", "currency code", currencyCode, "date", date)
        );


        return AutoRateMapper.MAPPER.mapToRateDto(optionalRate);
    }
}

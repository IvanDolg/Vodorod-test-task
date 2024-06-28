package com.testtask.test_task.mapper;

import com.testtask.test_task.dto.NationalBankCurrencyDto;
import com.testtask.test_task.entity.NationalBankCurrency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoNationalBankCurrencyMapper {
    AutoNationalBankCurrencyMapper MAPPER = Mappers.getMapper(AutoNationalBankCurrencyMapper.class);
    NationalBankCurrencyDto mapToNationalBankCurrencyDto(NationalBankCurrency currency);
    NationalBankCurrency mapToNationalBankCurrency(NationalBankCurrencyDto currencyDto);
}

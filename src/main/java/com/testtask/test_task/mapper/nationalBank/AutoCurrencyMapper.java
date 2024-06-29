package com.testtask.test_task.mapper.nationalBank;

import com.testtask.test_task.dto.nationalBank.CurrencyDto;
import com.testtask.test_task.entity.nationalBank.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoCurrencyMapper {
    AutoCurrencyMapper MAPPER = Mappers.getMapper(AutoCurrencyMapper.class);
    CurrencyDto mapToCurrencyDto(Currency currency);
    Currency mapToCurrency(CurrencyDto currencyDto);
}

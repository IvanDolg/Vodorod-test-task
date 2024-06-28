package com.testtask.test_task.mapper;

import com.testtask.test_task.dto.NationalBankRateDto;
import com.testtask.test_task.entity.NationalBankRate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoNationalBankRateMapper {
    AutoNationalBankRateMapper MAPPER = Mappers.getMapper(AutoNationalBankRateMapper.class);
    NationalBankRateDto mapToNationalBankRateDto(NationalBankRate rate);
    NationalBankRate mapToNationalBankRate(NationalBankRateDto rateDto);
}

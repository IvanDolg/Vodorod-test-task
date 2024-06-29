package com.testtask.test_task.mapper.nationalBank;

import com.testtask.test_task.dto.nationalBank.RateDto;
import com.testtask.test_task.entity.nationalBank.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoRateMapper {
    AutoRateMapper MAPPER = Mappers.getMapper(AutoRateMapper.class);
    RateDto mapToRateDto(Rate rate);
    Rate mapToRate(RateDto rateDto);
}

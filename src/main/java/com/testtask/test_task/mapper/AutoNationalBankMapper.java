package com.testtask.test_task.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoNationalBankMapper {
    AutoNationalBankMapper MAPPER = Mappers.getMapper(AutoNationalBankMapper.class);

}

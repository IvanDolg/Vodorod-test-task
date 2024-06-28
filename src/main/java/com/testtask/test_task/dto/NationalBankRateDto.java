package com.testtask.test_task.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NationalBankRateDto {
    private Long id;
    private Long curId;
    private LocalDate date;
    private String curAbbreviation;
    private Integer curScale;
    private String curName;
    private BigDecimal curOfficialRate;
}

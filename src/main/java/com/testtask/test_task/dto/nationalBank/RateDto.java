package com.testtask.test_task.dto.nationalBank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RateDto {
    private Long id;
    private Long curId;
    private LocalDate date;
    private String curAbbreviation;
    private Integer curScale;
    private String curName;
    private BigDecimal curOfficialRate;
}

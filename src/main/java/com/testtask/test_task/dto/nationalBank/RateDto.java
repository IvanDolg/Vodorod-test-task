package com.testtask.test_task.dto.nationalBank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateDto {
    private Long id;
    private Long curId;
    private LocalDate date;
    private String curAbbreviation;
    private Integer curScale;
    private String curName;
    private BigDecimal curOfficialRate;
}

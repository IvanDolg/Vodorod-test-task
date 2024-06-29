package com.testtask.test_task.dto.nationalBank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {
    private Long id;
    private Long parentId;
    private Integer code;
    private String abbreviation;
    private String name;
    private String nameBel;
    private String nameEng;
    private String quotName;
    private String quotNameBel;
    private String quotNameEng;
    private String nameMulti;
    private String nameBelMulti;
    private String nameEngMulti;
    private Integer scale;
    private Integer periodicity;
    private LocalDate dateStart;
    private LocalDate dateEnd;
}

package com.testtask.test_task.dto;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class NationalBankCurrencyDto {
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

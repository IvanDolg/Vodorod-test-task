package com.testtask.test_task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_national_banks")
public class NationalBankCurrency {
    @Id
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

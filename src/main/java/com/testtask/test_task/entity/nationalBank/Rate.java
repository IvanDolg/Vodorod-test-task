package com.testtask.test_task.entity.nationalBank;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_national_bank_rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long curId;
    private LocalDate date;
    private String curAbbreviation;
    private Integer curScale;
    private String curName;
    private BigDecimal curOfficialRate;
}

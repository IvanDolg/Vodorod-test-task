package com.testtask.test_task.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateNationalBank {
    private int Cur_ID;
    private LocalDate Date;
    private String Cur_Abbreviation;
    private int Cur_Scale;

    @JsonProperty(value = "Cur_Name")
    private String curName;
    private double Cur_OfficialRate;
}
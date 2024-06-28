package com.testtask.test_task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateShortNationalBank {
    private int cur_ID;
    private LocalDateTime date;
    private double cur_OfficialRate;
}

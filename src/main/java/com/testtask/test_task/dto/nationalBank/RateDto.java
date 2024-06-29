package com.testtask.test_task.dto.nationalBank;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "RateDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateDto {

    private Long id;

    @Schema(
            description = "Internal code"
    )
    private Long curId;

    @Schema(
            description = "The date on which the course is requested"
    )
    private LocalDate date;

    @Schema(
            description = "Letter code"
    )
    private String curAbbreviation;

    @Schema(
            description = "The number of units of foreign currency"
    )
    private Integer curScale;

    @Schema(
            description = "The name of the currency in Russian in the plural or singular, " +
                    "depending on the number of units"
    )
    private String curName;

    @Schema(
            description = "Course"
    )
    private BigDecimal curOfficialRate;
}

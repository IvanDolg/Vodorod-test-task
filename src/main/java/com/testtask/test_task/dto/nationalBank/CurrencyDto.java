package com.testtask.test_task.dto.nationalBank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(
        description = "CurrencyDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {

    @Schema(
            description = "Internal code"
    )
    private Long id;

    @Schema(
            description = "This code is used for communication, when changing the name, " +
                    "the number of units to which the exchange rate of the Belarusian ruble, " +
                    "alphabetic, numeric codes, etc. are set, in fact, of the same currency"
    )
    private Long parentId;

    @Schema(
            description = "Digital code"
    )
    private Integer code;

    @Schema(
            description = "Letter code"
    )
    private String abbreviation;

    @Schema(
            description = "Name of the currency in Russian"
    )
    private String name;

    @Schema(
            description = "Name of the currency in Belarusian"
    )
    private String nameBel;

    @Schema(
            description = "Name of the currency in English"
    )
    private String nameEng;

    @Schema(
            description = "The name of the currency in Russian, containing the number of units"
    )
    private String quotName;

    @Schema(
            description = "The name of the currency in Belarusian, containing the number of units"
    )
    private String quotNameBel;

    @Schema(
            description = "The name of the currency in English, containing the number of units"
    )
    private String quotNameEng;

    @Schema(
            description = "The name of the currency in Russian in the plural"
    )
    private String nameMulti;

    @Schema(
            description = "The name of the currency in Belarusian in the plural"
    )
    private String nameBelMulti;

    @Schema(
            description = "The name of the currency in English in the plural"
    )
    private String nameEngMulti;

    @Schema(
            description = "The number of units of foreign currency"
    )
    private Integer scale;

    @Schema(
            description = "The frequency of setting the course (0 – daily, 1 – monthly)"
    )
    private Integer periodicity;

    @Schema(
            description = "the date of inclusion of the currency in the list of currencies to which " +
                    "the official exchange rate of the white ruble is set"
    )
    private LocalDate dateStart;

    @Schema(
            description = "The date of exclusion of the currency from the list of currencies " +
                    "to which the official exchange rate of the white ruble is set"
    )
    private LocalDate dateEnd;
}

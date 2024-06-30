package com.testtask.test_task.controller.nationalBank;

import com.testtask.test_task.dto.nationalBank.RateDto;
import com.testtask.test_task.service.NationalBankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Rates",
        description = "API for loading and retrieving currency rates"
)
@RestController
@RequestMapping("/api/v1/rate")
@RequiredArgsConstructor
public class RateController {

    @Autowired
    private NationalBankService nationalBankService;

    @Operation(
            summary = "Load rates",
            description = "Fetches rates from the national bank for the given date and saves them to the database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Rates loaded successfully for the specified date"
    )
    @GetMapping("/rates/{date}")
    public ResponseEntity<String> loadRates(@PathVariable("date") String date) {
        nationalBankService.loadRates(date);
        return ResponseEntity.ok("Rates loaded successfully for date: " + date);
    }


    @Operation(
            summary = "Get rate",
            description = "Retrieves the currency rate for the given date and currency code."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Rate retrieved successfully"
    )
    @GetMapping("/{date}/{currency-code}")
    public ResponseEntity<RateDto> getRate(@PathVariable("date") String date,
                                           @PathVariable("currency-code") String currencyCode) {
        RateDto rateDto = nationalBankService.getRate(date, currencyCode);
        return ResponseEntity.ok(rateDto);
    }
}

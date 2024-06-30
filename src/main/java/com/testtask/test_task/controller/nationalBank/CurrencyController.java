package com.testtask.test_task.controller.nationalBank;

import com.testtask.test_task.dto.nationalBank.CurrencyDto;
import com.testtask.test_task.service.NationalBankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "Currencies",
        description = "API for loading and managing currencies"
)
@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {
    @Autowired
    private NationalBankService nationalBankService;

    @Operation(
            summary = "Load currencies",
            description = "Fetches currencies from the national bank and saves them to the database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Currencies loaded successfully"
    )
    @GetMapping
    public ResponseEntity<String> loadCurrencies() {
        nationalBankService.loadCurrencies();
        return ResponseEntity.ok("Currencies loaded successfully.");
    }

    @Operation(
            summary = "Get currency",
            description = "Retrieves the currency by its abbreviation."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Currency retrieved successfully"
    )
    @GetMapping("/{abbreviation}")
    public ResponseEntity<List<CurrencyDto>> getCurrenciesByAbbreviation(@PathVariable String abbreviation) {
        List<CurrencyDto> currencies = nationalBankService.getCurrencyByAbbreviation(abbreviation);
        return ResponseEntity.ok(currencies);
    }

}

package com.testtask.test_task.controller.nationalBank;

import com.testtask.test_task.service.NationalBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {
    @Autowired
    private NationalBankService nationalBankService;

    @GetMapping
    public ResponseEntity<String> loadCurrencies() {
        nationalBankService.loadCurrencies();
        return ResponseEntity.ok("Currencies loaded successfully.");
    }
}

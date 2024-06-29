package com.testtask.test_task.controller.nationalBank;

import com.testtask.test_task.dto.nationalBank.RateDto;
import com.testtask.test_task.service.NationalBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rate")
@RequiredArgsConstructor
public class RateController {

    @Autowired
    private NationalBankService nationalBankService;

    @GetMapping("/rates")
    public ResponseEntity<String> loadRates(@RequestParam String date) {
        nationalBankService.loadRates(date);
        return ResponseEntity.ok("Rates loaded successfully for date: " + date);
    }

    @GetMapping
    public ResponseEntity<RateDto> getRate(@RequestParam String date,
                                           @RequestParam String currencyCode) {
        RateDto rateDto = nationalBankService.getRate(date, currencyCode);
        return ResponseEntity.ok(rateDto);
    }
}

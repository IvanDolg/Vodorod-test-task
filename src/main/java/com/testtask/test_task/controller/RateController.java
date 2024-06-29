package com.testtask.test_task.controller;

import com.testtask.test_task.entity.nationalBank.Rate;
import com.testtask.test_task.service.NationalBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String loadRates(@RequestParam String date) {
        nationalBankService.loadRates(date);
        return "Rates loaded successfully for date: " + date;
    }

    @GetMapping
    public Rate getRate(@RequestParam String date, @RequestParam String currencyCode) {
        return nationalBankService.getRate(date, currencyCode);
    }
}

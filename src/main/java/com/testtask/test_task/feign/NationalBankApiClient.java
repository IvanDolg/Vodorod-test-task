package com.testtask.test_task.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(name = "nationalBankApiClient", url = "https://api.nbrb.by")
public interface NationalBankApiClient {

    @GetMapping("/exrates/currencies")
    List<Map<String, Object>> getCurrencies();

    @GetMapping("/exrates/rates")
    List<Map<String, Object>> getRates(@RequestParam("ondate") String date,
                                       @RequestParam("periodicity") int periodicity);
}
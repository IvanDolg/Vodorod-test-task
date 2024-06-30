package com.testtask.test_task.repository.nationalBank;

import com.testtask.test_task.entity.nationalBank.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findByAbbreviation(String curAbbreviation);
}

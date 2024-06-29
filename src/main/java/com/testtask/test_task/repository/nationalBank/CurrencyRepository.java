package com.testtask.test_task.repository.nationalBank;

import com.testtask.test_task.entity.nationalBank.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}

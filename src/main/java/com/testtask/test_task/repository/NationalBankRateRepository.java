package com.testtask.test_task.repository;

import com.testtask.test_task.entity.NationalBankRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface NationalBankRateRepository extends JpaRepository<NationalBankRate, Long> {
    Optional<NationalBankRate> findByCurAbbreviationAndDate(String curAbbreviation, LocalDate date);
}

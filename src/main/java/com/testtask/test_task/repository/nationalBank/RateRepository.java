package com.testtask.test_task.repository.nationalBank;

import com.testtask.test_task.entity.nationalBank.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Long> {
    Optional<Rate> findByCurAbbreviationAndDate(String curAbbreviation, LocalDate date);
}

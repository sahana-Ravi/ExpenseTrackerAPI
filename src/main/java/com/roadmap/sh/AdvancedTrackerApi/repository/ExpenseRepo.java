package com.roadmap.sh.AdvancedTrackerApi.repository;

import com.roadmap.sh.AdvancedTrackerApi.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, UUID> {
    List<Expense> findByUserId(UUID userId);
    List<Expense> findByUserIdAndCreatedAtGreaterThanEqual(
            UUID userId,
            Instant createdAt
    );
    List<Expense> findByUserIdAndCreatedAtBetween(
            UUID userId,
            Instant from,
            Instant to
    );
}

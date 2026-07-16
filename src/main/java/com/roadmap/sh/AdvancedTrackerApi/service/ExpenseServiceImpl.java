package com.roadmap.sh.AdvancedTrackerApi.service;

import com.roadmap.sh.AdvancedTrackerApi.dto.ExpenseDto;
import com.roadmap.sh.AdvancedTrackerApi.entity.Expense;
import com.roadmap.sh.AdvancedTrackerApi.entity.User;
import com.roadmap.sh.AdvancedTrackerApi.mapper.ExpenseMapper;
import com.roadmap.sh.AdvancedTrackerApi.repository.ExpenseRepo;
import com.roadmap.sh.AdvancedTrackerApi.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    ExpenseRepo expenseRepo;
    ExpenseMapper expenseMapper;
    UserRepo userRepo;

    @Override
    public List<ExpenseDto> findAll() {
        UUID uuid = getLoggedInUserId();
        List<Expense> expenses = expenseRepo.findByUserId(uuid);
        List<ExpenseDto> expenseDtos = new ArrayList<>();
        for(Expense expense : expenses){
            expenseDtos.add(expenseMapper.toExpenseDto(expense));
        }

        return expenseDtos;
    }

    @Override
    public List<ExpenseDto> getLastWeekExpenses() {
        UUID userId = getLoggedInUserId();

        Instant oneWeekAgo = Instant.now().minus(7, ChronoUnit.DAYS);

        List<Expense> expenses =
                expenseRepo.findByUserIdAndCreatedAtGreaterThanEqual(
                        userId,
                        oneWeekAgo
                );

        return expenses.stream()
                .map(expenseMapper::toExpenseDto)
                .toList();

    }

    @Override
    public List<ExpenseDto> getLastMonthExpenses() {
        UUID userId = getLoggedInUserId();

        Instant oneMonthAgo = LocalDate.now()
                .minusMonths(1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant();

        List<Expense> expenses =
                expenseRepo.findByUserIdAndCreatedAtGreaterThanEqual(
                        userId,
                        oneMonthAgo
                );

        return expenses.stream()
                .map(expenseMapper::toExpenseDto)
                .toList();
    }

    @Override
    public boolean addExpense(ExpenseDto expenseDto) {
        boolean isCreated = false;
        UUID userId = getLoggedInUserId();
        User user = userRepo.getReferenceById(userId);
        Expense expense = expenseMapper.toExpense(expenseDto);
        expense.setUser(user);
        expenseRepo.save(expense);
        isCreated = true;
        return isCreated;

    }

    @Override
    public List<ExpenseDto> getExpensesByCustomDate(Date fromDate, Date toDate) {

        UUID userId = getLoggedInUserId();

        Instant fromInstant = fromDate.toInstant();
        Instant toInstant = toDate.toInstant();

        List<Expense> expenses = expenseRepo.findByUserIdAndCreatedAtBetween(
                userId,
                fromInstant,
                toInstant
        );

        return expenses.stream()
                .map(expenseMapper::toExpenseDto)
                .toList();

    }

    @Override
    public boolean updateExpense(UUID expenseId, ExpenseDto expenseDto) {
        if(expenseRepo.findById(expenseId) == null) {
            return false;
        }
        Expense expense = expenseMapper.toExpense(expenseDto);
        expenseRepo.save(expense);
        return true;
    }

    @Override
    public boolean deleteExpense(UUID expenseId) {
        if(expenseRepo.findById(expenseId) == null) {
            return false;
        }
        expenseRepo.deleteById(expenseId);
        return true;
    }

    public UUID getLoggedInUserId() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        return user.getId();
    }
}

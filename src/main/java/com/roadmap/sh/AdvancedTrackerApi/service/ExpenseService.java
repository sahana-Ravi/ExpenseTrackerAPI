package com.roadmap.sh.AdvancedTrackerApi.service;

import com.roadmap.sh.AdvancedTrackerApi.dto.ExpenseDto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ExpenseService {
    List<ExpenseDto>  findAll();

    List<ExpenseDto> getLastWeekExpenses();
    List<ExpenseDto> getLastMonthExpenses();
    boolean addExpense(ExpenseDto expenseDto);
    List<ExpenseDto> getExpensesByCustomDate(Date fromDate, Date toDate);
    boolean updateExpense(UUID expenseId, ExpenseDto expenseDto);
    boolean deleteExpense(UUID expenseId);

}

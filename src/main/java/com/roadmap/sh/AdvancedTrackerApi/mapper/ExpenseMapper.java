package com.roadmap.sh.AdvancedTrackerApi.mapper;


import com.roadmap.sh.AdvancedTrackerApi.dto.ExpenseDto;
import com.roadmap.sh.AdvancedTrackerApi.entity.Expense;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

    public Expense toExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setDescription(expenseDto.getDescription());
        expense.setCost(expenseDto.getCost());
        return expense;
    }
    public ExpenseDto toExpenseDto(Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setDescription(expense.getDescription());
        expenseDto.setCost(expense.getCost());
        return expenseDto;
    }
}


package com.roadmap.sh.AdvancedTrackerApi.controller;


import com.roadmap.sh.AdvancedTrackerApi.dto.ExpenseDto;
import com.roadmap.sh.AdvancedTrackerApi.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ExpenseContorller {

    ExpenseService expenseService;

    @GetMapping(value = "/getAllExpenses")
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.findAll());
    }
    @PostMapping( value = "/addExpneses")
    public ResponseEntity<String> addExpneses(@RequestBody ExpenseDto expneses) {
        boolean isAdded = expenseService.addExpense(expneses);
        if(!isAdded){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Expense not added");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Expense added");
    }
    @GetMapping(value = "/pastWeek")
    public ResponseEntity<List<ExpenseDto>> getLastWeekExpenses(){
       return ResponseEntity.status(HttpStatus.OK).body(expenseService.getLastWeekExpenses());
    }
    @GetMapping(value = "/pastMonth")
    public ResponseEntity<List<ExpenseDto>> getLastMonthExpenses(){
       return ResponseEntity.status(HttpStatus.OK).body(expenseService.getLastMonthExpenses());
    }
    @GetMapping(value = "/customDate")
    public ResponseEntity<List<ExpenseDto>> getCustomDateExpenses(@RequestParam Date fromDate, @RequestParam Date toDate){
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getExpensesByCustomDate(fromDate,toDate));
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateExpneses(@RequestParam UUID expenseId, @RequestBody ExpenseDto expneses) {
       boolean isUpdated = expenseService.updateExpense(expenseId, expneses);
       if(!isUpdated){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Expense not updated");
       }
       return ResponseEntity.status(HttpStatus.OK).body("Expense updated");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteExpneses(@RequestParam UUID expenseId) {
        boolean  isDeleted = expenseService.deleteExpense(expenseId);
        if(!isDeleted){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Expense not deleted");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Expense deleted");
    }

}

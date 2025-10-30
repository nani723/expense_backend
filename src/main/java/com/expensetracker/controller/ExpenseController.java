package com.expensetracker.controller;

import com.expensetracker.dto.ExpenseRequest;
import com.expensetracker.dto.ExpenseResponse;
import com.expensetracker.dto.StatsResponse;
import com.expensetracker.service.ExpenseService;
import com.expensetracker.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:5173")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final JwtService jwtService;

    public ExpenseController(ExpenseService expenseService, JwtService jwtService) {
        this.expenseService = expenseService;
        this.jwtService = jwtService;
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> getAllExpenses(
            @RequestHeader("Authorization") String token) {
        Long userId = jwtService.extractUserId(token.substring(7));
        List<ExpenseResponse> expenses = expenseService.getAllExpenses(userId);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> getExpenseById(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token) {
        Long userId = jwtService.extractUserId(token.substring(7));
        ExpenseResponse expense = expenseService.getExpenseById(id, userId);
        return ResponseEntity.ok(expense);
    }

    @PostMapping
    public ResponseEntity<ExpenseResponse> createExpense(
            @Valid @RequestBody ExpenseRequest request,
            @RequestHeader("Authorization") String token) {
        Long userId = jwtService.extractUserId(token.substring(7));
        ExpenseResponse expense = expenseService.createExpense(request, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(expense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseResponse> updateExpense(
            @PathVariable Long id,
            @Valid @RequestBody ExpenseRequest request,
            @RequestHeader("Authorization") String token) {
        Long userId = jwtService.extractUserId(token.substring(7));
        ExpenseResponse expense = expenseService.updateExpense(id, request, userId);
        return ResponseEntity.ok(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token) {
        Long userId = jwtService.extractUserId(token.substring(7));
        expenseService.deleteExpense(id, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> getStats(
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String category,
            @RequestHeader("Authorization") String token) {
        Long userId = jwtService.extractUserId(token.substring(7));
        StatsResponse stats = expenseService.getStats(userId, month, year, category);
        return ResponseEntity.ok(stats);
    }
}




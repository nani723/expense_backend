package com.expensetracker.service;

import com.expensetracker.dto.ExpenseRequest;
import com.expensetracker.dto.ExpenseResponse;
import com.expensetracker.dto.StatsResponse;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;
import com.expensetracker.repository.ExpenseRepository;
import com.expensetracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public List<ExpenseResponse> getAllExpenses(Long userId) {
        return expenseRepository.findByUserId(userId)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public ExpenseResponse getExpenseById(Long id, Long userId) {
        Expense expense = expenseRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        return convertToResponse(expense);
    }

    public ExpenseResponse createExpense(ExpenseRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Expense expense = new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDate(request.getDate());
        expense.setUser(user);

        Expense savedExpense = expenseRepository.save(expense);
        return convertToResponse(savedExpense);
    }

    public ExpenseResponse updateExpense(Long id, ExpenseRequest request, Long userId) {
        Expense expense = expenseRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDate(request.getDate());

        Expense updatedExpense = expenseRepository.save(expense);
        return convertToResponse(updatedExpense);
    }

    public void deleteExpense(Long id, Long userId) {
        if (!expenseRepository.findByIdAndUserId(id, userId).isPresent()) {
            throw new RuntimeException("Expense not found");
        }
        expenseRepository.deleteByIdAndUserId(id, userId);
    }

    public StatsResponse getStats(Long userId, Integer month, Integer year, String category) {
        List<Expense> expenses = getFilteredExpenses(userId, month, year, category);

        double totalExpenses = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        long totalTransactions = expenses.size();
        double averageExpense = totalTransactions > 0 ? totalExpenses / totalTransactions : 0.0;

        // Calculate this month's total
        LocalDate now = LocalDate.now();
        YearMonth currentMonth = YearMonth.now();
        double thisMonthTotal = expenses.stream()
                .filter(e -> {
                    YearMonth expenseMonth = YearMonth.from(e.getDate());
                    return expenseMonth.equals(currentMonth);
                })
                .mapToDouble(Expense::getAmount)
                .sum();

        return new StatsResponse(totalExpenses, thisMonthTotal, averageExpense, totalTransactions);
    }

    private List<Expense> getFilteredExpenses(Long userId, Integer month, Integer year, String category) {
        List<Expense> expenses = expenseRepository.findByUserId(userId);

        if (category != null && !category.isEmpty()) {
            expenses = expenses.stream()
                    .filter(e -> e.getCategory().equals(category))
                    .collect(Collectors.toList());
        }

        if (year != null) {
            expenses = expenses.stream()
                    .filter(e -> e.getDate().getYear() == year)
                    .collect(Collectors.toList());
        }

        if (month != null) {
            expenses = expenses.stream()
                    .filter(e -> e.getDate().getMonthValue() == month)
                    .collect(Collectors.toList());
        }

        return expenses;
    }

    private ExpenseResponse convertToResponse(Expense expense) {
        return new ExpenseResponse(
                expense.getId(),
                expense.getTitle(),
                expense.getAmount(),
                expense.getCategory(),
                expense.getDate()
        );
    }
}




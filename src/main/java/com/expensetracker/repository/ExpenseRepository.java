package com.expensetracker.repository;

import com.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
    List<Expense> findByUserId(Long userId);
    
    Optional<Expense> findByIdAndUserId(Long id, Long userId);
    
    void deleteByIdAndUserId(Long id, Long userId);
    
    @Query("SELECT e FROM Expense e WHERE e.user.id = :userId AND YEAR(e.date) = :year")
    List<Expense> findByUserIdAndYear(@Param("userId") Long userId, @Param("year") int year);
    
    @Query("SELECT e FROM Expense e WHERE e.user.id = :userId AND YEAR(e.date) = :year AND MONTH(e.date) = :month")
    List<Expense> findByUserIdAndMonth(@Param("userId") Long userId, @Param("year") int year, @Param("month") int month);
    
    @Query("SELECT e FROM Expense e WHERE e.user.id = :userId AND e.category = :category")
    List<Expense> findByUserIdAndCategory(@Param("userId") Long userId, @Param("category") String category);
}




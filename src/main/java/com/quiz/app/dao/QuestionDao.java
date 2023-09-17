package com.quiz.app.dao;

import com.quiz.app.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository <Questions, Integer> {
    List<Questions> findByCategory(String category);
}
package com.quiz.app.controller;

import com.quiz.app.Questions;
import com.quiz.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    //To get all the questions listed in the table
    @GetMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions()
    {

            return questionService.getAllQuestions();
    }

    //To get all the questions in the requested category
    @GetMapping("category/{category}")
    public ResponseEntity<List<Questions>> getQuestionByCategory(@PathVariable String category)
    {
        return questionService.getAllQuestionsByCategory(category);
    }

    //To add questions
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions questions)
    {

        return questionService.addQuestion(questions);
    }

    //To update existing questions
    @PutMapping("update")
    public ResponseEntity<String> updateQuestion(@RequestBody Questions question){
        return questionService.updateQuestion(question);
    }

    //To delete a question
   @DeleteMapping(path="delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id)
   {
        return questionService.deleteQuestion(id);
   }

  // @GetMapping("id/")
}

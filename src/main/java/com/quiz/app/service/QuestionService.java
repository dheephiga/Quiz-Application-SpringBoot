package com.quiz.app.service;

import com.quiz.app.Questions;
import com.quiz.app.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Questions>> getAllQuestions() {

        try{
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<List<Questions>> getAllQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addQuestion(Questions questions) {
         try{
             questionDao.save(questions);
             return new ResponseEntity<>("question added successfully",HttpStatus.CREATED);
         }
         catch (Exception e){
             e.printStackTrace();
         }
        return new ResponseEntity<>("Unable to add",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Integer id){
        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("question deleted successfully",HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Unable to perform deletion",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Questions question) {
        try{
            questionDao.saveAndFlush(question);
            return new ResponseEntity<>("Question " + question.getID() + " added successfully",HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Unable to update question",HttpStatus.BAD_REQUEST);
    }
}
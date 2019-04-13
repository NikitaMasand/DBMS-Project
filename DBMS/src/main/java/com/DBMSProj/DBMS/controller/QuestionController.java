package com.DBMSProj.DBMS.controller;

import com.DBMSProj.DBMS.entities.Questions;
import com.DBMSProj.DBMS.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/question")

public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/showAllQuestions", method = RequestMethod.GET)
    public List<Questions> showAllQuestions(){
        return questionService.showAllQuestions();
    }

    @RequestMapping(value = "/practice", method = RequestMethod.GET)
    public List<Questions> practiceDisplay(){
        return questionService.practiceDisplay();
    }

    @RequestMapping(value ="/saveResponse",method = {RequestMethod.POST})
    public void saveResponse(@RequestBody HashMap Answers, int user_id) {
         questionService.saveResponse(Answers, user_id);
    }
}

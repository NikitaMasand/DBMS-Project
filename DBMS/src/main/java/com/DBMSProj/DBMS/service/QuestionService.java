package com.DBMSProj.DBMS.service;

import com.DBMSProj.DBMS.entities.Questions;
import com.DBMSProj.DBMS.repository.QuestionRepository;
import com.DBMSProj.DBMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service


public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public List<Questions> showAllQuestions() {
        return questionRepository.showAllQuestions();
    }


    public List<Questions> practiceDisplay() {
        return questionRepository.practiceDisplay();
    }

    public void saveResponse(HashMap answers, int user_id) {
        answers.forEach((key,value)-> compareEach((Integer) key,(Integer) value, user_id));
    }
    public void compareEach(int question_id, int givenanswer, int user_id){
        int correct_answer = questionRepository.compare(question_id);
        if(correct_answer == givenanswer) {
            int weight = questionRepository.findWeight(question_id);
            questionRepository.incrementScore(user_id,weight);

        }

    }
}

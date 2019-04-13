package com.DBMSProj.DBMS.repository;

import com.DBMSProj.DBMS.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Integer> {

    @Query(value = "SELECT question_id,tag,question,option1,option2,option3,option4,weight FROM questions", nativeQuery = true)
    List showAllQuestions();


    @Query(value = "SELECT question_id,tag,question,option1,option2,option3,option4,weight FROM questions ORDER BY Rand() LIMIT 10", nativeQuery = true)
    List practiceDisplay();

    @Query(value = "SELECT answer FROM questions WHERE question_id = ?1",nativeQuery = true)
    int compare(int question_id);


    @Query(value= "SELECT weight FROM questions WHERE question_id = ?1", nativeQuery = true)
    int findWeight(int question_id);

    @Query(value = "UPDATE user SET total_score = (total_score + weight=?2) WHERE user_id = ?1", nativeQuery = true)
    void incrementScore(int user_id,int weight);
}

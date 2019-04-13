package com.DBMSProj.DBMS.repository;

import com.DBMSProj.DBMS.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value ="select * from user",nativeQuery = true)
    List<User> findAllUsers();

    @Query(
            value = "INSERT INTO 'dbms_project'.'user' ('user_id', 'fname', 'lname', 'username', 'email', 'password', 'year', 'branch')" +
                    " VALUES (user.user_id, user.fname, user.lname, user.username, user.email, user.password, user.year, user.branch);",
            nativeQuery = true)
    void saveData(User user);

    @Query(
            value = "SELECT * FROM user u WHERE u.username =?1", nativeQuery = true)
    User findUserDetails(String userName);

    @Query(
            value = "SELECT total_score FROM user u WHERE u.user_id = ?1",nativeQuery = true
    )
    Integer getUserScore(Integer user_id);
}

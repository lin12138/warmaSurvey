package cn.nicholasld.survey.repository;

import cn.nicholasld.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author NicholasLD
 * @date 2022/11/16 02:07
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    //添加一个问卷
    @Modifying
    @Transactional
    @Query(value = "insert into survey (s_id,user_id,survey,submit_time) values (null,:uid,:survey,:stime)",nativeQuery = true)
    void addSurvey(@Param("uid") String userID,@Param("survey") String survey,@Param("stime") Timestamp submitTime);

    //根据用户id查询问卷
    @Query(value = "select * from survey where user_id = :uid order by submit_time desc limit 1",nativeQuery = true)
    Survey findSurveyByUserID(@Param("uid") String userID);

    //根据问卷id查询问卷
    @Query(value = "select * from survey where s_id = :sid",nativeQuery = true)
    Survey findSurveyBySurveyID(@Param("sid") int surveyID);

    //根据用户ID查询最新的问卷id
    @Query(value = "select s_id from survey where user_id = :uid order by submit_time desc limit 1",nativeQuery = true)
    int findSurveyIdByUserId(@Param("uid") String userID);
}

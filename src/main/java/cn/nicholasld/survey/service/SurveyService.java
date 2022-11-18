package cn.nicholasld.survey.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.nicholasld.survey.entity.Question;
import cn.nicholasld.survey.entity.Survey;
import cn.nicholasld.survey.repository.SurveyRepository;
import cn.nicholasld.survey.result.SurveyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author NicholasLD
 * @date 2022/11/16 02:13
 */
@Service
public class SurveyService {
    @Autowired
    SurveyRepository surveyRepository;

    //添加问卷
    public boolean addSurvey(String userId, String survey){
        try{
            //获取当前时间
            surveyRepository.addSurvey(userId,survey, Timestamp.valueOf(DateUtil.now()));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //根据用户id查问卷
    public SurveyResult findSurveyByUserId(String userId){
        try{
            Survey survey = surveyRepository.findSurveyByUserID(userId);
            Question question =JSONUtil.toBean(survey.getSurvey(),Question.class);
            SurveyResult surveyResult = new SurveyResult();
            surveyResult.setsId(survey.getsId());
            surveyResult.setUserId(survey.getUserId());
            surveyResult.setQuestion(question);
            surveyResult.setSubmitTime(survey.getSubmitTime());
            return surveyResult;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //根据问卷id查问卷
    public SurveyResult findSurveyBySurveyId(int surveyId){
        try{
            Survey survey = surveyRepository.findSurveyBySurveyID(surveyId);
            Question question =JSONUtil.toBean(survey.getSurvey(),Question.class);
            SurveyResult surveyResult = new SurveyResult();
            surveyResult.setsId(survey.getsId());
            surveyResult.setUserId(survey.getUserId());
            surveyResult.setQuestion(question);
            surveyResult.setSubmitTime(survey.getSubmitTime());
            return surveyResult;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //根据用户id查询最新的问卷id
    public int findNewSurveyIdByUserId(String userId){
        try{
            return surveyRepository.findSurveyIdByUserId(userId);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

}

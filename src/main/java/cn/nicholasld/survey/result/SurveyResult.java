package cn.nicholasld.survey.result;

import cn.nicholasld.survey.entity.Question;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.sql.Timestamp;

/**
 * @author NicholasLD
 * @date 2022/11/16 23:56
 */
public class SurveyResult {
    int sId;
    String userId;
    Timestamp submitTime;
    Question question;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "SurveyResult{" +
                "sId=" + sId +
                ", userId=" + userId +
                ", submitTime=" + submitTime +
                ", question=" + question +
                '}';
    }
}

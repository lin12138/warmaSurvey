package cn.nicholasld.survey.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author NicholasLD
 * @date 2022/11/16 01:49
 */
@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id", nullable = false)
    int sId;

    @Column(name = "user_id", nullable = false)
    String userId;

    @Column(name = "survey", nullable = false)
    String survey;

    @Column(name = "submit_time", nullable = false)
    Timestamp submitTime;


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

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "sId=" + sId +
                ", userId=" + userId +
                ", survey='" + survey + '\'' +
                ", submitTime=" + submitTime +
                '}';
    }
}

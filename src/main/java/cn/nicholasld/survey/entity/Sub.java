package cn.nicholasld.survey.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NicholasLD
 * @date 2022/11/16 21:45
 */
public class Sub {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("survey")
    Question survey;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Question getSurvey() {
        return survey;
    }

    public void setSurvey(Question survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "Sub{" +
                "userId='" + userId + '\'' +
                ", survey=" + survey +
                '}';
    }
}

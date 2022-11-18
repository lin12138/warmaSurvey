package cn.nicholasld.survey.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import cn.nicholasld.survey.entity.Question;
import cn.nicholasld.survey.entity.Sub;
import cn.nicholasld.survey.entity.Survey;
import cn.nicholasld.survey.result.JsonResult;
import cn.nicholasld.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author NicholasLD
 * @date 2022/11/16 02:23
 */
@Controller
public class SurveyController {
    @Autowired
    SurveyService surveyService;

    @GetMapping("/")
    public String index(){
        return "error";
    }

    //打开问卷页面
    @GetMapping("/survey/{userId}")
    public String openSurveyPage(@PathVariable("userId") String userId, Model model) {
        System.out.println("userId = " + userId);
        if (userId == null || userId.equals("")) {
            System.out.println("空");
            model.addAttribute("error", "用户ID不合法");
            return "error";
        }
        //正则表达式判断是否为数字
        if (!userId.matches("[0-9]+")) {
            model.addAttribute("error", "用户ID不合法");
            return "error";
        }
        model.addAttribute("userId", userId);
        return "index";
    }

    //提交问卷
    @PostMapping("/submitSurvey")
    @ResponseBody
    public JsonResult submitSurvey(@RequestBody Sub survey) {
        System.out.println(survey);
        if (survey == null) {
            return new JsonResult(400,"参数不能为空");
        }
        if(Objects.equals(survey.getUserId(), "") || survey.getUserId() == null){
            return new JsonResult(400,"用户ID不能为空");
        }

        if (surveyService.addSurvey(survey.getUserId(), JSONUtil.toJsonStr(survey.getSurvey()))) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", "提交成功");
            map.put("surveyId", surveyService.findNewSurveyIdByUserId(survey.getUserId()));
            map.put("userId", survey.getUserId());
            return new JsonResult(200,map);
        }
        return new JsonResult(400,"未知错误");
    }

    //根据ID获取问卷
    @ResponseBody
    @GetMapping("/getSurvey")
    public JsonResult getSurvey(String type,String id, String token) {
        if(type == null || type.equals("")){
            return new JsonResult(400,"type不能为空");
        }
        if (id == null || id.equals("")) {
            return new JsonResult(400,"ID不合法");
        }
        //正则表达式判断是否为数字
        if (!id.matches("[0-9]+")) {
            return new JsonResult(400,"ID不合法");
        }
        if(token == null || token.equals("")){
            return new JsonResult(400,"token不能为空");
        }
        if(!token.equals("1145141919180")){
            return new JsonResult(400,"token不合法");
        }
        if(type.equals("userid")){
            System.out.println(new JsonResult(200,surveyService.findSurveyByUserId(id)));
            return new JsonResult(200,surveyService.findSurveyByUserId(id));
        }
        if(type.equals("surveyid")){
            return new JsonResult(200,surveyService.findSurveyBySurveyId(Integer.parseInt(id)));
        }
        return new JsonResult(400,"未知错误");
    }
}
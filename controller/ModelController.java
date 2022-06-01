package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * @author lyj
 * @Title: DemoController
 * @ProjectName springmvc-demo
 * @Description: TODO
 * @date 2020/6/9 21:21
 */
@Controller
@RequestMapping("/demo")
public class ModelController {
    /**
     * http://localhost:8080/demo/handle01
     */
    @RequestMapping("/handle01")
    public ModelAndView handle01(){
        Date date=new Date();


        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("date",date);
        modelAndView.setViewName("success");
        System.out.println("modelAndView----"+modelAndView.getClass());


        return modelAndView;
    }


    /**
     * http://localhost:8080/demo/handle02
     */
    @RequestMapping("/handle02")
    public String handle02(ModelMap modelMap){
        Date date=new Date();


        modelMap.addAttribute("date",date);
        System.out.println("modelMap------"+modelMap.getClass());


        return "success";
    }


    /**
     * http://localhost:8080/demo/handle03
     */
    @RequestMapping("/handle03")
    public String handle03(Model model){
        Date date=new Date();
        model.addAttribute("date",date);
        System.out.println("model-----"+model.getClass());


        return "success";
    }
    /**
     * http://localhost:8080/demo/handle04
     */
    @RequestMapping("/handle04")
    public String handle04(Map<String,Object> map){
        Date date=new Date();
        map.put("date",date);
        System.out.println("map------"+map.getClass());


        return "success";
    }
}

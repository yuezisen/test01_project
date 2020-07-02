package com.yuezisen.hello_demo.servlet;

import com.yuezisen.hello_demo.POJO.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Map;

@Controller
public class helloController {
    @Autowired
    Person person;
    @ResponseBody
    @RequestMapping("/hello")
    public ModelAndView hello (){
        ModelAndView mv = new ModelAndView("index" , (Map<String, ?>) person);
        return mv;
    }
}

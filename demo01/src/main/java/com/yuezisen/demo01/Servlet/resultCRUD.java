package com.yuezisen.demo01.Servlet;

import com.yuezisen.demo01.Mappers.EmployeeMapper;
import com.yuezisen.demo01.POJO.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 名字 邮箱
 * @date 2020-7-9
 * Copyright© 2008-2020 苏州同元软控信息技术有限公司 All Rights Reserved.
 */

@Controller
public class resultCRUD {
    @Autowired
    EmployeeMapper employeeMapper;
    private List<Employee> list;
    private Employee employee;

    /**
     * 员工列表界面
     * @param model
     * @return
     */
    @RequestMapping("/gotolist")
    public String inlist(Model model){
        list = employeeMapper.SelectAll();
        model.addAttribute("list",list);
        return "emplist";
    }
    /**
     * 员工添加页面
     * @param lastname
     * @param email
     * @param gender
     * @return
     */
    @PostMapping("/addemp")
    public String addemp(@RequestParam("lastName") String lastname,
                        @RequestParam("email") String email,
                         @RequestParam("gender") Integer gender){
        Employee employee = new Employee();
        employee.setLastName(lastname);
        employee.setEmail(email);
        employee.setGender(gender);
        System.out.println(employee);
        employeeMapper.Insertemp(employee);
        return"redirect:/gotolist";
    }
    /**
     * 跳转员工修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/gotoupate/{id}")
    public String updateuser(@PathVariable("id") Integer id,Model model){
       employee = employeeMapper.SelectById(id);
       model.addAttribute("emp",employee);
        return "updatePage";
    }

    /**
     * 将员工的修改信息提价更新并重定向到员工列表中
     * @param id
     * @param name
     * @param email
     * @param gender
     * @return
     */
    @RequestMapping("/updatemsg/{id}")
    public String updateupto(   @PathVariable("id")Integer id,
                                @RequestParam("lastName") String name,
                                @RequestParam("email") String email,
                                @RequestParam("gender") Integer gender){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setLastName(name);
        employee.setEmail(email);
        employee.setGender(gender);
        employeeMapper.UpdateUser(employee);
        return "redirect:/gotolist";
    }

    /**
     * 删除用户通过id的形式
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public String deleteuser(@PathVariable("id")Integer id){
        //System.out.println("this data is deleting for :"+id);
        employeeMapper.deleteUser(id);
        return "redirect:/gotolist";
    }
}

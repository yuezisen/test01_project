package com.yuezisen.demo01.Mappers;

import com.yuezisen.demo01.POJO.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 名字 邮箱
 * @date 2020-7-9
 * Copyright© 2008-2020 苏州同元软控信息技术有限公司 All Rights Reserved.
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from emp where id = #{id}")
    @Results({
        @Result(column = "id",property = "id"),
        @Result(column = "last_name",property = "lastName"),
        @Result(column = "emp_email",property = "email"),
        @Result(column = "emp_gender",property = "gender"),
        @Result(property = "id", column = "emp_id",
            one = @One(select = "com.yuezisen.demo01.Mappers.DepartmentMapper.selectById"))
    })
    public Employee SelectById(Integer id);

    @Select("select * from emp")
    @Results({
        @Result(column = "id",property = "id"),
        @Result(column = "last_name",property = "lastName"),
        @Result(column = "emp_email",property = "email"),
        @Result(column = "emp_gender",property = "gender")
    })
    public List<Employee> SelectAll();

    @Update("update emp "
        + "set "
        + "emp.last_name=#{lastName},emp.emp_email=#{email},emp.emp_gender=#{gender} "
        + "where id = #{id}")
    public void UpdateUser(Employee employee);

    @Insert("INSERT INTO "
        + "emp(emp.last_name,emp.emp_email,emp.emp_gender) "
        + "VALUES"
        + "(#{lastName}, #{email},#{gender})")
    public void Insertemp(Employee employee);

    @Delete("DELETE FROM emp WHERE id=#{id}")
    public void deleteUser(Integer id);
}

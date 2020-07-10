package com.yuezisen.demo01.Mappers;

import com.yuezisen.demo01.POJO.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author 名字 邮箱
 * @date 2020-7-9
 * Copyright© 2008-2020 苏州同元软控信息技术有限公司 All Rights Reserved.
 */
@Mapper
public interface DepartmentMapper {
    @Select("select * from dpt where id = #{id}")
    @Results({
        @Result(column = "id" ,property = "id"),
        @Result(column = "dpt_name" ,property = "departmentName"),
        @Result(column = "emp_id" ,property = "EmpId")
    })
    public Department selectById(Integer id);


}

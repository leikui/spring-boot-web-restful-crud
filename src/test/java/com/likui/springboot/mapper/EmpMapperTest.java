package com.likui.springboot.mapper;

import com.likui.springboot.eneity.Employee;
import com.likui.springboot.vo.EmployeesVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: EmpMapperTest
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-12 15:26
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void addEmp(){
        Employee employee= new Employee();
        employee.setDeptId(1);
        employee.setEmail("123@qq.com");
        employee.setGender(1);
        employee.setLastName("zhangsan");
        Integer result = employeeMapper.addEmp(employee);
        System.out.println("result..." + result);

    }

    @Test
    public void selectEmp(){
        List<EmployeesVO> employees = employeeMapper.selectAllEmp();
        System.out.println(employees.get(0).toString());
        System.out.println("list.size()..." + employees.size());
    }

}
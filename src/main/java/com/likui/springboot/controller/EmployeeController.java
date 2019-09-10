package com.likui.springboot.controller;

import com.likui.springboot.eneity.Department;
import com.likui.springboot.eneity.Employee;
import com.likui.springboot.mappers.DepartmentDao;
import com.likui.springboot.mappers.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @ClassName: EmployeeController
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-9 16:31
 * @Version: 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    /**
     * 查询所有员工信息列表
     * @return
     */
    @GetMapping("emps")
    public String empList(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 进入员工添加页面
     * @return
     */
    @GetMapping("emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 员工添加
     * SpringMVC自动将请求的参数和入参对象的进行一一绑定
     * 要求是请求参数名字和javaBean对象入参的属性名一样
     */
    @PostMapping("emp")
    public String addEmp( Employee employee){

        System.out.println("employee信息："+ employee);
        //redirect 重定向
        employeeDao.save(employee);
        return "redirect:emps";
    }

    /**
     * 查出当前员工信息 在修改页面回填
     * @return
     */
    @GetMapping("emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        model.addAttribute("emp",employee);
        //回到修改页面 (add页面 修改 添加 重用)
        return "emp/add";
    }

    /**
     * 员工修改  需要提交员工id
     */
    @PutMapping("emp")
    public String updateEmp(Employee employee){
        System.out.println("修改的员工数据" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 员工删除
     */
    @DeleteMapping("emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){

        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
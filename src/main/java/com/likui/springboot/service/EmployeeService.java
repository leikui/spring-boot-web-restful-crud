package com.likui.springboot.service;

import com.likui.springboot.eneity.Employee;
import com.likui.springboot.vo.EmployeesVO;

import java.util.List;

/**
 * @ClassName: EmployeeService
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-12 17:43
 * @Version: 1.0
 */
public interface EmployeeService {
    /**
     * 添加部门
     */
    Integer addEmp(Employee employee);

    /**
     * 根据id 查询员工
     * @param empId
     * @return
     */
    Employee selectEmp(Integer empId);

    /**
     * 查询所有员工
     * @return
     */
    List<EmployeesVO> selectAllEmp();

    /**
     * 修改员工信息
     * @param empId
     * @return
     */
    Integer updateEmp(Integer empId);

    /**
     * 删除员工
     * @param empId
     * @return
     */
    Integer delEmp(Integer empId);

}
package com.likui.springboot.service.serviceImpl;

import com.likui.springboot.eneity.Employee;
import com.likui.springboot.mapper.EmployeeMapper;
import com.likui.springboot.service.EmployeeService;
import com.likui.springboot.vo.EmployeesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: EmployeeServiceImpl
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-12 17:43
 * @Version: 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 添加员工
     *
     * @param employee
     */
    @Override
    public Integer addEmp(Employee employee) {
        if (employee == null) {
            throw new RuntimeException("employee为空！");
        }
        Integer rows = employeeMapper.addEmp(employee);
        if (rows != 1){
            throw new RuntimeException("添加失败");
        }
        return rows;
    }

    /**
     * 根据id 查询员工
     *
     * @param empId
     * @return
     */
    @Override
    public Employee selectEmp(Integer empId) {
        return null;
    }

    /**
     * 查询所有员工
     *
     * @return
     */
    @Override
//    @CachePut/*方法运行完 在存入缓存  同步更新缓存*/
//    @Cacheable/*方法运行之前将结果放入缓存*/
    @Cacheable(cacheNames = "emp",key = "#root.methodName")
    public List<EmployeesVO> selectAllEmp() {
        System.out.println("从数据库查询执行了。。");
        List<EmployeesVO> employees = employeeMapper.selectAllEmp();
        System.out.println("从数据库查询结束。。");
        return employees;
    }

    /**
     * 修改员工信息
     *
     * @param empId
     * @return
     */
    @Override
    public Integer updateEmp(Integer empId) {

        return null;
    }

    /**
     * 删除员工
     *
     * @param empId
     * @return
     */
    @Override
    public Integer delEmp(Integer empId) {
        return null;
    }
}
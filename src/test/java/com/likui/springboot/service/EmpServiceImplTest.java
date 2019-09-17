package com.likui.springboot.service;

import com.likui.springboot.eneity.Employee;
import com.likui.springboot.service.serviceImpl.EmployeeServiceImpl;
import com.likui.springboot.vo.EmployeesVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: EmpServiceImplTest
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-12 17:52
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceImplTest {

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串
    @Autowired
    RedisTemplate redisTemplate;//操作对象
    @Autowired
    RedisTemplate<Object, EmployeesVO> empRedisTemplate;//自定义序列化规则
    /**
     * redis 常见五大数据类型
     *     String ,list ,set , hash （散列）, ZSet(有序集合）
     */
    @Test
    public void test01(){
        //保存数据到redis
        //stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println("msg" + msg);
//        stringRedisTemplate.opsForList().leftPush("mylist","1");
//        stringRedisTemplate.opsForList().leftPush("mylist","2");
    }

    /**
     * 测试保存对象
     */
    @Test
    public void testRedisObj(){
        List<EmployeesVO> employeesVOS = employeeService.selectAllEmp();
        //默认如果保存对象 则使用jdk序列化机制 序列化后的数据保存到redis中
        redisTemplate.opsForValue().set("emp_01",employeesVOS.get(0));
        /*
         *将数据以json的方式保存
         *  1、自己将对象转换为json
         * 2、redisTemplate默认的序列化规则 改变默认的序列化规则
         */
        empRedisTemplate.opsForValue().set("emp_02",employeesVOS.get(0));
    }

    @Test
    public void addEmp(){
        Employee employee= new Employee();
        employee.setDeptId(1);
        employee.setEmail("123@qq.com");
        employee.setGender(1);
        employee.setLastName("lisi");
        Integer result = employeeService.addEmp(employee);
        System.out.println("result..." + result);
    }
}
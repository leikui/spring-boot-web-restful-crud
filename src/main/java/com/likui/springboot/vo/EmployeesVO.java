package com.likui.springboot.vo;

/**
 * @ClassName: Employees
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-12 18:04
 * @Version: 1.0
 */

/**
 * 所有员工 vo 类
 */
public class EmployeesVO {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private String departmentName;

    @Override
    public String toString() {
        return "EmployeesVO{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
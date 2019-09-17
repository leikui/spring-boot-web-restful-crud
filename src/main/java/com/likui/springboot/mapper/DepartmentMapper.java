package com.likui.springboot.mapper;

import com.likui.springboot.eneity.Department;

public interface DepartmentMapper {

    /**
     * 添加部门
     * @param department
     * @return
     */
    Integer addDepartment(Department department);
    /**
     * 修改部门
     * @param deptId
     * @return
     */
    Integer updateDepartment(Integer deptId);
    /**
     * 删除部门
     * @param deptId
     * @return
     */
    Integer delDepartment(Integer deptId);



}

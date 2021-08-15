package com.example.demo.dao;

import com.example.demo.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffDao {
    /*通过staffid查询staff*/
    public Staff selectStaffById(String StaffId);

    /*查询同一部门的员工,通过部门*/
    public List<Staff> selectStaffOfIdenticalDepart(String depart);
}

package com.example.demo.service;

import com.example.demo.dao.StaffDao;
import com.example.demo.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffImp {
    @Autowired
    StaffDao staffDao;

    /*通过id拿Staff*/
    public Staff selectStaffById(String id){
        return staffDao.selectStaffById(id);
    }

    /*查询所有同部门的员工，通过某一个id*/
    public List<Staff> selectStaffIdenticalDepartById(String staffId){
        String depart=staffDao.selectStaffById(staffId).getDepartment();
        return staffDao.selectStaffOfIdenticalDepart(depart);
    }
}

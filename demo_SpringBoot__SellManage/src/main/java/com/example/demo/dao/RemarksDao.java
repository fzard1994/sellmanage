package com.example.demo.dao;

import com.example.demo.pojo.Remarks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RemarksDao {
    /*查询所有信息，通过客户Id*/
    List<Remarks> selectAllRemarksByCustomerId(String customerID);
    /*增加客户info*/
    int insertRemarks(Remarks remarks);
}

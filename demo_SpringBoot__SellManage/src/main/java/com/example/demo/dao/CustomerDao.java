package com.example.demo.dao;

import com.example.demo.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerDao {

    /*查询所有客户byOwner*/
    List<Customer> selectAllCustomerByOwner(String Owner);

    /*放入回收站*/
    void insertToRecycleBin(String customerId);

    /*查询客户，通过id*/
    Customer selectCustomerById(String customerId);

    /*修改意向度，通过id*/
    int updateIntention(@Param("customerId") String customerId,@Param("intention") String intention);

    /*修改客户owner，通过客户id，和员工id*/
    int updateCustmerOwnerByStaffIdAndCusId(@Param("staffId") String staffId,@Param("customerId") String customerId);

    /*查询员工和客户对于的关系*/
    List<Customer> selectAllCustomerIdenticalDepart(@Param("depart") String depart);
    List<Customer> selectAllCustomerByStaffIdAndIntention(@Param("staffId") String staffId,@Param("intention") String intention);
    List<Customer> selectAllCustomerByDepartAndIntention(@Param("depart") String depart,@Param("intention") String intention);
    List<Customer> selectAllCustomerByStaffId(@Param("staffId") String staffId);

}

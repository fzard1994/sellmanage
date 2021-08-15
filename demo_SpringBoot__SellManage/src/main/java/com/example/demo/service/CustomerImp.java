package com.example.demo.service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerImp {
    @Autowired
    CustomerDao customerDao;

    /*查询所有客户通过owner*/
    public List<Customer> selectAllCustomerByOwner(String Owner){
        return customerDao.selectAllCustomerByOwner(Owner);
    }

    /*放入回收站*/
    @Async
    public void insertRecycleBin(String customerId){
        customerDao.insertToRecycleBin(customerId);
    }

    /*查询客户，通过id*/
    public Customer selectCustomerById(String customerId){
        return customerDao.selectCustomerById(customerId);
    }

    /*修改客户的意向*/
    public int updateIntention(String customerId,String intention){
        return customerDao.updateIntention(customerId,intention);
    }
    /*从回收站中放到自己库*/
    public int insertCustomerBin(String staffId,String customerId){
        return customerDao.updateCustmerOwnerByStaffIdAndCusId(staffId,customerId);
    }

    public List<Customer> selectAllCustomerIdenticalDepart(String depart){
        return customerDao.selectAllCustomerIdenticalDepart(depart);
    }

    public List<Customer> selectAllCustomerByStaffIdAndIntention(String staffId,String intention){
        return customerDao.selectAllCustomerByStaffIdAndIntention(staffId,intention);
    }

    public List<Customer> selectAllCustomerByDepartdAndIntention(String depart,String intention){
        return customerDao.selectAllCustomerByDepartAndIntention(depart, intention);
    }

    public List<Customer> selectAllCustomerByStaffId(String staffId){
        return customerDao.selectAllCustomerByStaffId(staffId);
    }

    /*多次处理修改情况*/
    public String updateCustomerOwner(String[] customerId,String staffId){
        int value=0;
        for (int i=0;i<customerId.length;i++){
            value+=customerDao.updateCustmerOwnerByStaffIdAndCusId(staffId,customerId[i]);
        }
        if (value==customerId.length){
            return "success";
        }
        return "fail";
    }
}

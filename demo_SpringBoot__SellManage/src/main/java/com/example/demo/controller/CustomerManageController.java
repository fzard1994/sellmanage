package com.example.demo.controller;

import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerImp;
import com.example.demo.service.StaffImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/CustomerManage")
public class CustomerManageController {
    @Autowired
    CustomerImp customerImp;
    @Autowired
    StaffImp staffImp;

    @RequestMapping(value = "/selectAllCustomerByOwner")
    @ResponseBody
    public List<Customer> selectAllCustomerByOwner(HttpServletRequest request){
        String staffId= (String) request.getSession().getAttribute("staffId");
        return customerImp.selectAllCustomerByOwner(staffId);
    }

    @RequestMapping(value = "/insertRecycleBin")
    public String insertRecycleBin(String customerId){
        System.out.println("执行了");
        customerImp.insertRecycleBin(customerId);
        return "customerManage";
    }
}

package com.example.demo.controller;

import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/RecycleBinController")
public class RecycleBinController {
    @Autowired
    CustomerImp customerImp;

    @RequestMapping(value = "/selectAllCustomerByRecycle")
    @ResponseBody
    public List<Customer> selectAllCustomerByRecycle(){
        return customerImp.selectAllCustomerByOwner("recyclebin");
    }

    @RequestMapping(value = "/insertCustomerBin")
    public String insertCustomerBin(String customerId, HttpServletRequest request){
        customerImp.insertCustomerBin((String) request.getSession().getAttribute("staffId"),customerId);
        return "RecycleBin";
    }
}

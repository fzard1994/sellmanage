package com.example.demo.controller;

import com.example.demo.pojo.Customer;
import com.example.demo.pojo.Staff;
import com.example.demo.service.CustomerImp;
import com.example.demo.service.StaffImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/ManagerController")
public class ManagerController {
    @Autowired
    StaffImp staffImp;
    @Autowired
    CustomerImp customerImp;

    @RequestMapping(value = "/selectStaff")
    @ResponseBody
    public List<Staff> selectStaff(HttpServletRequest request){
        String staffId= (String) request.getSession().getAttribute("staffId");
       return staffImp.selectStaffIdenticalDepartById(staffId);
    }

    @ResponseBody
    @RequestMapping(value = "/defaultSelect")
    public List<Customer> defaultSelect(HttpServletRequest request){
        String depart=staffImp.selectStaffById((String) request.getSession().getAttribute("staffId")).getDepartment();
        return customerImp.selectAllCustomerIdenticalDepart(depart);
    }

    @ResponseBody
    @RequestMapping(value = "/selectCustomerByStaffIdAndIntention")
    public List<Customer> selectCustomerByStaffIdAndIntention(String staffId,String intention,HttpServletRequest request){
        String depart=staffImp.selectStaffById((String) request.getSession().getAttribute("staffId")).getDepartment();
        if ("all".equals(staffId)){
           if ("all".equals(intention)){
               return customerImp.selectAllCustomerIdenticalDepart(depart);
           }
           return customerImp.selectAllCustomerByDepartdAndIntention(depart,intention);
       }else if ("all".equals(intention)){
            return customerImp.selectAllCustomerByStaffId(staffId);
        }
        return customerImp.selectAllCustomerByStaffIdAndIntention(staffId,intention);
    }

    @ResponseBody
    @RequestMapping(value = "/giveSomeOne")
    public String giveSomeOne(String[] list,String staffId){
        String result=customerImp.updateCustomerOwner(list,staffId);
        if ("success".equals(result)){
            return "分配成功";
        }
        return "修改失败";
    }
}

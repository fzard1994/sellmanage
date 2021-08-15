package com.example.demo.controller;

import com.example.demo.pojo.Remarks;
import com.example.demo.service.CustomerImp;
import com.example.demo.service.RemarksImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/RemarksController")
public class RemarksController {
    @Autowired
    CustomerImp customerImp;
    @Autowired
    RemarksImp remarksImp;

    @RequestMapping(value ="/RemarksPage")
    public String RemarksPage(Model model, HttpServletRequest request){
        String customerId=request.getParameter("customerId");
        String name=customerImp.selectCustomerById(customerId).getName();
        String intention=customerImp.selectCustomerById(customerId).getIntention();
        model.addAttribute("customerName",name);
        model.addAttribute("customerId",customerId);
        model.addAttribute("customerIntention",intention);
        return "Remarks";
    }


    @RequestMapping(value ="/DefaultIterator")
    @ResponseBody
    public List<Remarks> DefaultIterator(String customerId){
        return remarksImp.selectAllRemarksByCustomerId(customerId);
    }

    @RequestMapping(value = "/insertInfo")
    @ResponseBody
    public String insertInfo(String info,String customerId,HttpServletRequest request){
        String staffid= (String) request.getSession().getAttribute("staffId");
        int result=remarksImp.insertRemarks(info,customerId,staffid);
        if (result!=0){
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping(value = "/updateIntention")
    public String updateIntention(String customerId,String intention){
        System.out.println(customerId+"和"+intention);
        int result=customerImp.updateIntention(customerId,intention);
        if (result!=0){
            return "success";
        }
        return "fail";
    }
}

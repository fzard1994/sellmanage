package com.example.demo.controller;

import com.example.demo.service.StaffImp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Controller
public class loginClr {
    @Autowired
    StaffImp staffImp;

    @RequestMapping(value = "/login")
    public String login(
            String staffId, String password,
            RedirectAttributesModelMap model,
            HttpServletRequest request
                        ){
        /*通过shiro判断*/
        UsernamePasswordToken token=new UsernamePasswordToken(staffId,password);
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);
            model.addFlashAttribute("msg","登录成功");
            request.getSession().setAttribute("Staffname",staffImp.selectStaffById(staffId).getName());
            request.getSession().setAttribute("staffId",staffId);
            return "redirect:/templates/html/mainPage.html";

        }catch (UnknownAccountException e){
            model.addFlashAttribute("msg","账号不对");
            return "redirect:/";
        }catch (IncorrectCredentialsException e){
            model.addFlashAttribute("msg","密码不对");
            return "redirect:/";
        }

    }
}

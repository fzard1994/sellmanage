package com.example.demo;

import com.example.demo.dao.CustomerDao;
import com.example.demo.dao.RemarksDao;
import com.example.demo.pojo.Customer;
import com.example.demo.pojo.Remarks;
import com.example.demo.pojo.Staff;
import com.example.demo.service.CustomerImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    RemarksDao remarksDao;
    @Autowired
    CustomerImp customerImp;
    @Autowired
    CustomerDao customerDao;
    @Test
    void contextLoads() {
        List<Customer> list=customerDao.selectAllCustomerIdenticalDepart("1");
        for (Customer c :list
                ) {
            System.out.println(c.toString());
        }
/*        remarksDao.selectAllRemarksByCustomerId("fdafd");*/
    }

}

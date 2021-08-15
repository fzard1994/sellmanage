package com.example.demo.service;

import com.example.demo.dao.RemarksDao;
import com.example.demo.pojo.Remarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RemarksImp {
    @Autowired
    RemarksDao remarksDao;

    /*查询所有备注信息，通过customerID*/
    public List<Remarks> selectAllRemarksByCustomerId(String customerID){
        return remarksDao.selectAllRemarksByCustomerId(customerID);
    }

    /*添加详细信息*/
    public int insertRemarks(String info,String customerId,String staffId) {
        Remarks remarks = new Remarks();
        remarks.setCustomerId(customerId);
        remarks.setContactsId(staffId);
        remarks.setDetails(info);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy:mm:ss");
        remarks.setTime(simpleDateFormat.format(date));

        return remarksDao.insertRemarks(remarks);
    }
}

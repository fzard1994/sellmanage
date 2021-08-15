package com.example.demo.pojo;

public class Customer {
    private String name;
    private String customerId;
    private String sex;
    private String Tel;
    private String job;
    private String owner;
    private String intention;
    /*多表联合使用*/
    private String staffname;

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerId='" + customerId + '\'' +
                ", sex='" + sex + '\'' +
                ", Tel='" + Tel + '\'' +
                ", job='" + job + '\'' +
                ", owner='" + owner + '\'' +
                ", intention='" + intention + '\'' +
                ", staffname='" + staffname + '\'' +
                '}';
    }
}

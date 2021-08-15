package com.example.demo.pojo;

public class Remarks {
    private String id;
    private String customerId;
    private String contactsId;
    private String details;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getContactsId() {
        return contactsId;
    }

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Remarks{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", contactsId='" + contactsId + '\'' +
                ", details='" + details + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

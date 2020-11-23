package com.tmt.paymentmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String code;
    private String description;
    private int days;
    private int remindBeforeDays;

    @CreationTimestamp
    @Generated(GenerationTime.ALWAYS)
    @Temporal(TemporalType.DATE)
    private Date CreationDate = new java.sql.Date(new java.util.Date().getDate());

    public Payment() { }
    public Payment(int id, String code, String description, int days, int remindBeforeDays, Date creationDate) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.days = days;
        this.remindBeforeDays = remindBeforeDays;
        CreationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getRemindBeforeDays() {
        return remindBeforeDays;
    }

    public void setRemindBeforeDays(int remindBeforeDays) {
        this.remindBeforeDays = remindBeforeDays;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }
}

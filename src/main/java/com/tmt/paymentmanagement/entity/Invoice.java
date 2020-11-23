package com.tmt.paymentmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    private String invoiceNumber;
    private Date invoiceDate;
    private String paymentTerm;
    private String status;

    public Invoice(String invoiceNumber, Date invoiceDate, String paymentTerm, String status) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.paymentTerm = paymentTerm;
        this.status = status;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.tmt.paymentmanagement;

import com.tmt.paymentmanagement.entity.Invoice;
import com.tmt.paymentmanagement.entity.Payment;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class JobScheduler implements Job {

    private final Payment payment;
    private final Invoice invoice;

    @Autowired
    public JobScheduler(Payment payment, Invoice invoice) {

        this.payment = payment;
        this.invoice = invoice;
    }

    public void execute(JobExecutionContext jobContext) throws JobExecutionException {

        if (invoice.getStatus()=="UNPAID") {
            //if(invoice.getPaymentTerm()=="NET 30")
            throw new RuntimeException("Reminder sent for"+invoice.getInvoiceNumber());
        }
    }

}

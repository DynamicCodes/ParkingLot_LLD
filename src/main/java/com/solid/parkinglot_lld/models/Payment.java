package com.solid.parkinglot_lld.models;

@lombok.Getter
@lombok.Setter
public class Payment extends BaseModel{
    private Bill bill;
    private PaymentType paymentType;
    private int amount;
    private String transactionId;
    private PaymentStatus paymentStatus;

    public Payment(int id, Bill bill, PaymentType paymentType, int amount, String transactionId, PaymentStatus paymentStatus) {
        super(id);
        this.bill = bill;
        this.paymentType = paymentType;
        this.amount = amount;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
    }




}

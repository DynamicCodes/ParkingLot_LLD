package com.solid.parkinglot_lld.models;

public class Operator extends BaseModel{
    private String name;
    public Operator(String name) {
        super(-1);
        this.name = name;
    }
}

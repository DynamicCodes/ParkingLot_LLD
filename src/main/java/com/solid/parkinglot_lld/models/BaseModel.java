package com.solid.parkinglot_lld.models;

import java.util.Date;

@lombok.Getter
@lombok.Setter
public class BaseModel {
    private int id;
    private Date createdAt;
    private Date updatedAt;

    public BaseModel(int id) {
        this.id = id;
    }
}

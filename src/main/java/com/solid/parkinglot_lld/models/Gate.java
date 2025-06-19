package com.solid.parkinglot_lld.models;



@lombok.Getter
@lombok.Setter
public class Gate extends BaseModel {
    private String number;
    private GateType gateType;
    private GateStatus gateStatus;
    private Operator operator;

    public Gate(int id, String number, GateType gateType,
                GateStatus gateStatus, Operator operator) {
        super(id);
        this.number = number;
        this.gateType = gateType;
        this.gateStatus = gateStatus;
        this.operator = operator;
    }
}

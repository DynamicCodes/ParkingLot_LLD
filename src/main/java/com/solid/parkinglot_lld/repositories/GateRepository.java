package com.solid.parkinglot_lld.repositories;

import com.solid.parkinglot_lld.models.Gate;
import com.solid.parkinglot_lld.models.GateStatus;
import com.solid.parkinglot_lld.models.GateType;
import com.solid.parkinglot_lld.models.Operator;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.ExpressionState;


import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    Map<Integer, Gate> gates;
    public GateRepository() {
        this.gates = new TreeMap<Integer, Gate>();
        Gate gate = new Gate(1, "1", GateType.ENTRY,
                GateStatus.OPERTIONAL, new Operator("abc"));
        gates.put(1, gate);
    }

    public Optional<Gate> findById(int gate_id){
        return Optional.ofNullable(gates.get(gate_id));
    }
}

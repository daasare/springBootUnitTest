package com.unitTest.demo.service;


import com.unitTest.demo.dto.Operands;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticService {

    public ResponseEntity<?> add(Operands operands) {
        double result = operands.firstOperand() + operands.secondOperand();
        String formatedResult = String.format("%f + %f = %f", operands.firstOperand(), operands.secondOperand(), result);
        return ResponseEntity.ok(formatedResult);
    }
}

package com.unitTest.demo.controller;


import com.unitTest.demo.dto.Operands;
import com.unitTest.demo.service.ArithmeticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArithmeticController {

    private final ArithmeticService arithmeticService;

    @PostMapping("/addition")
    public ResponseEntity<?> add(@RequestBody Operands operands) {
        return arithmeticService.add(operands);
    }
}

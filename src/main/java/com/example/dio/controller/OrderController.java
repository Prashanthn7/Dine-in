package com.example.dio.controller;

import com.example.dio.dto.response.OrderResponse;
import com.example.dio.service.OrderService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/Orders/tables/{tableId}")
    public ResponseEntity<ResponseStructure<OrderResponse>> createOrder(@PathVariable long tableId){
       OrderResponse response=  orderService.createOrder(tableId);
       return ResponseBuilder.created(response,"Order Generated SuccessFully");
    }
}

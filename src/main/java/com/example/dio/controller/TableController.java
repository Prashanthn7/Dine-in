package com.example.dio.controller;

import com.example.dio.dto.request.TableRequest;
import com.example.dio.dto.response.TableResponse;
import com.example.dio.service.TableService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class TableController {

    private final TableService tableService;
    @PostMapping("/tables/{userId}")
    public ResponseEntity<ResponseStructure<TableResponse>> createTable(@RequestBody TableRequest tableRequest, @PathVariable long userId){
     TableResponse response = tableService.createTable(tableRequest,userId);
     return ResponseBuilder.success(HttpStatus.CREATED,"Table Created",response);
    }
}

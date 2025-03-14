package com.example.dio.controller;

import com.example.dio.service.QRService;
import com.example.dio.util.ResponseStructure;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class QRController {
    
    private final QRService qrService;

    @GetMapping(value="/qr",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> createQrCode(@RequestParam("url") String url){
        byte[] qrImage= null;
        try {
            qrImage = qrService.createQrCode(url);
        } catch (WriterException | IOException e ) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);

    }
}

package com.example.dio.service;

import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

public interface QRService {

    byte[] createQrCode(@RequestParam("url") String url)throws WriterException, IOException ;
}

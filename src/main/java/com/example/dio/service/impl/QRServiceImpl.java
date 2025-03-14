package com.example.dio.service.impl;

import com.example.dio.service.QRService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QRServiceImpl implements QRService {
    @Override
    public byte[] createQrCode(String url) throws WriterException , IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =qrCodeWriter.encode(url, BarcodeFormat.QR_CODE,250,250);
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            MatrixToImageWriter.writeToStream(bitMatrix,"PNG",byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }

    }
}

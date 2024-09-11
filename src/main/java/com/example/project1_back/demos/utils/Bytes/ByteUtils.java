package com.example.project1_back.demos.utils.Bytes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Component
public class ByteUtils {

    public ByteUtils(){}
    public byte[]  getBytesByStream(InputStream inputStream){
        byte[] bytes = new byte[1024];

        int b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            while((b = inputStream.read(bytes)) != -1){

                byteArrayOutputStream.write(bytes,0,b);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

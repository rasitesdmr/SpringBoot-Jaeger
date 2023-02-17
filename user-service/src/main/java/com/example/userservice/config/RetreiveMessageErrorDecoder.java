package com.example.userservice.config;

import com.example.userservice.exception.DepartmentNotFoundException;
import com.example.userservice.exception.DepartmentServiceUnavailableException;

import feign.Response;
import feign.codec.ErrorDecoder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;



@Component
@Slf4j
public class RetreiveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 404:
                log.error("{}" , response.request().url() + " Böyle bir departman yok");
                throw new DepartmentNotFoundException("Böyle bir departman yok");

            case 503:
                throw new DepartmentServiceUnavailableException("Departman servisinde yaşanan aksaklık sonucu kayıt gerçekleşmiyor");

        }
        return errorDecoder.decode(methodKey, response);
    }
}






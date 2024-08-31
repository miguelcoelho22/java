package com.example.evento_microservicos.service;

import com.example.evento_microservicos.dto.EmailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "servico-de-email", url = "http://localhost:8090/api/email")
public interface EmailServiceClient {

    @PostMapping("/")
    void mandarEmail(@RequestBody EmailDTO emailDto);

}

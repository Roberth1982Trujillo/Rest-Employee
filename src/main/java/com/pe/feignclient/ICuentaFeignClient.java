package com.pe.feignclient;

import com.pe.entity.Cuenta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Rest-Cuenta-FeignClient", url = "http://localhost:9003")
public interface ICuentaFeignClient {

    @PostMapping("/api/cuenta/crearCuenta")
    public String crearCuenta(@RequestBody Cuenta cuenta);
}
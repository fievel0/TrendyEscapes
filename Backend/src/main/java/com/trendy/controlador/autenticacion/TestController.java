package com.trendy.controlador.autenticacion;

import com.trendy.config.security.bean.UserDetailsServiceImpl;
import com.trendy.entidades.dtos.autenticacion.LoginRequestDTO;
import com.trendy.entidades.dtos.autenticacion.LoginResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class TestController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO){
        return new ResponseEntity<>(userDetailsService.loginUser(loginRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/test")
    public String testSecured(){
        return "THERE is security here and token is working";
    }

}

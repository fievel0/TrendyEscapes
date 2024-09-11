package com.trendy;

import com.trendy.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TrendyEscapesApplication  {


    @Autowired
    ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(TrendyEscapesApplication.class, args);
    }

}

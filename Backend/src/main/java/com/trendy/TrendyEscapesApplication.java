package com.trendy;

import com.trendy.entidades.cliente.Cliente;
import com.trendy.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TrendyEscapesApplication  implements CommandLineRunner {


    @Autowired
    ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(TrendyEscapesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Up and running");

    }
}

package com.trendy.config.initialization.impl;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendy.config.initialization.DataInitializer;
import com.trendy.entidades.Paquete.Pais;
import com.trendy.repositorio.CiudadRepository;
import com.trendy.repositorio.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
@Order(2)
public class CitiesInitializer implements DataInitializer {

    private final PaisRepository paisRepository;

    private final CiudadRepository ciudadRepository;

    @Autowired
    public CitiesInitializer(PaisRepository paisRepository, CiudadRepository ciudadRepository) {
        this.paisRepository = paisRepository;
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public void initialize() throws IOException, InterruptedException {

        System.out.println("HOLI");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Pais> paises = paisRepository.findAll();

        for(Pais pais : paises){
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://world-countries-data.p.rapidapi.com/cities/get-all-cities-by-country/" + pais.getId_pais() ))
                    .header("x-rapidapi-key", "83aa214fbamsh89c01c8a4cb7961p19ed09jsn4d92620cd232")
                    .header("x-rapidapi-host", "world-countries-data.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }

    }
}

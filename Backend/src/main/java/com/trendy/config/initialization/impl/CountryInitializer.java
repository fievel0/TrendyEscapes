package com.trendy.config.initialization.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendy.config.initialization.DataInitializer;
import com.trendy.entidades.Paquete.Pais;
import com.trendy.repositorio.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

@Service
@Order(1)
public class CountryInitializer implements DataInitializer {

    private final PaisRepository paisRepository;

    @Autowired
    public CountryInitializer(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public void initialize() throws IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://world-countries-data.p.rapidapi.com/countries/all-countries"))
                .header("x-rapidapi-key", "83aa214fbamsh89c01c8a4cb7961p19ed09jsn4d92620cd232")
                .header("x-rapidapi-host", "world-countries-data.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Mapear JSON a entidad.
        Pais[] paises = objectMapper.readValue(response.body(), Pais[].class);

        paisRepository.saveAll(Arrays.stream(paises).toList());
    }
}

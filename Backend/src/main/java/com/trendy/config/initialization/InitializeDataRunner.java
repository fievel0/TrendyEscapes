package com.trendy.config.initialization;

import com.trendy.entidades.Paquete.Pais;
import com.trendy.repositorio.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitializeDataRunner implements CommandLineRunner {


    private final List<DataInitializer> dataInitializers;

    private final PaisRepository paisRepository;

    @Autowired
    public InitializeDataRunner(List<DataInitializer> dataInitializers, PaisRepository paisRepository) {
        this.dataInitializers = dataInitializers;
        this.paisRepository = paisRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // SI no se ha inicializado la tabla Paises, entonces correr todos los inicializadores
        if (paisRepository.count() == 0) {
            for (DataInitializer dataInitializer : dataInitializers) {
                dataInitializer.initialize();
            }
        }
    }


}



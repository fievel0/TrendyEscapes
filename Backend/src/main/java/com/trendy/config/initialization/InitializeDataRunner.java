package com.trendy.config.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializeDataRunner implements CommandLineRunner {


    private final PaqueteInitializer paqueteInitializer;


    @Autowired
    public InitializeDataRunner(PaqueteInitializer paqueteInitializer) {
        this.paqueteInitializer = paqueteInitializer;
    }

    @Override
    public void run(String... args) throws Exception {
        paqueteInitializer.initialize();
        System.out.println("Paquetes inicializados");
    }


}



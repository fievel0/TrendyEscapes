package com.trendy.config.initialization;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendy.entidades.Paquete.Ciudad;
import com.trendy.entidades.Paquete.Pais;
import com.trendy.entidades.Paquete.Paquete;
import com.trendy.entidades.Paquete.TipoPaquete;
import com.trendy.repositorio.CiudadRepository;
import com.trendy.repositorio.PaisRepository;
import com.trendy.repositorio.PaqueteRepository;
import com.trendy.repositorio.TipoPaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class PaqueteInitializer {

    private final PaisRepository paisRepository;

    private final CiudadRepository ciudadRepository;

    private final TipoPaqueteRepository tipoPaqueteRepository;

    private final PaqueteRepository paqueteRepository;

    @Value("${package.json.path}")
    private String paquetesJsonPath; // Path to the JSON file

    @Autowired
    public PaqueteInitializer(PaisRepository paisRepository, CiudadRepository ciudadRepository,
                              TipoPaqueteRepository tipoPaqueteRepository, PaqueteRepository paqueteRepository) {
        this.paisRepository = paisRepository;
        this.ciudadRepository = ciudadRepository;
        this.tipoPaqueteRepository = tipoPaqueteRepository;
        this.paqueteRepository = paqueteRepository;
    }

    public void initialize() {
        // Si ya hay paquetes entonces ignoramos la inicialización
        if(paqueteRepository.count() != 0)  return ;

        String baseUrl = "/images/imagen_paquete_";
        int conteoImagen = 1;

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Load the JSON file from classpath (application.properties)
        ClassPathResource resource = new ClassPathResource(paquetesJsonPath);
        try (InputStream inputStream = resource.getInputStream()) {
            // Deserialize JSON file into Paquete
            Paquete[] paquetesJSON = objectMapper.readValue(inputStream, Paquete[].class);
            // Insertar cada paquete con sus respectivas entidades dependientes
            for(Paquete paqueteJSON : paquetesJSON) {
                Pais paisPaquete = paisRepository.getPaisByNombrePais(paqueteJSON.getPais().getNombrePais());
                TipoPaquete tipoPaquete = tipoPaqueteRepository.getTipoPaqueteByDescripcion(paqueteJSON.getTipoPaquete().getDescripcion());
                List<Ciudad> ciudades = new ArrayList<>();
                // Por cada ciudad persistir y/o agregar a la lista de ciudades
                for (Ciudad ciudad : paqueteJSON.getCiudadList()) {
                    if (!ciudadRepository.existsByNombreCiudad(ciudad.getNombreCiudad())) {
                        ciudad.setIdPais(paisPaquete);
                        Ciudad ciudadGuardada = ciudadRepository.save(ciudad);
                        ciudades.add(ciudadGuardada);
                    } else { // Si ya existe la ciudad en la base de datos entonces simplemente traerla del repositorio y agregarla a la lista de ciudades
                        ciudades.add(ciudadRepository.getCiudadByNombreCiudad(ciudad.getNombreCiudad()));
                    }
                }
                String imageUrl = baseUrl + conteoImagen + ".jpg";
                conteoImagen++;
                // Ahora con todas las entidades dependientes procedemos a crear un paquete y persisirlo
                Paquete nuevoPaquete = new Paquete(null, paqueteJSON.getNombrePaquete(), paqueteJSON.getDescripcion(),
                        paqueteJSON.getCostoPaquete(), paqueteJSON.isHotel(), imageUrl,
                        ciudades, tipoPaquete, paisPaquete, paqueteJSON.getHistorialCompras());

                paqueteRepository.save(nuevoPaquete);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



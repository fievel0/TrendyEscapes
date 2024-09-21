package com.trendy.mapper;

import com.trendy.entidades.Paquete.Pais;
import com.trendy.entidades.Paquete.Paquete;
import com.trendy.entidades.dtos.paquete.PaqueteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-21T10:51:02-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class PaqueteMapperImpl implements PaqueteMapper {

    @Override
    public PaqueteDTO paqueteToPaqueteDTO(Paquete paquete) {
        if ( paquete == null ) {
            return null;
        }

        String nombre = null;
        Long id = null;
        int costo = 0;
        List<String> ciudades = null;
        String pais = null;
        String tipoPaquete = null;
        String descripcion = null;
        boolean hotel = false;
        String foto = null;

        nombre = paquete.getNombrePaquete();
        id = paquete.getIdPaquete();
        costo = paquete.getCostoPaquete();
        ciudades = mapCiudades( paquete.getCiudadList() );
        pais = paquetePaisNombrePais( paquete );
        tipoPaquete = mapTipoPaquete( paquete.getTipoPaquete() );
        descripcion = paquete.getDescripcion();
        hotel = paquete.isHotel();
        foto = paquete.getFoto();

        PaqueteDTO paqueteDTO = new PaqueteDTO( id, nombre, descripcion, costo, hotel, foto, tipoPaquete, pais, ciudades );

        return paqueteDTO;
    }

    @Override
    public List<PaqueteDTO> paquetesToPaquetesDTO(List<Paquete> paquetes) {
        if ( paquetes == null ) {
            return null;
        }

        List<PaqueteDTO> list = new ArrayList<PaqueteDTO>( paquetes.size() );
        for ( Paquete paquete : paquetes ) {
            list.add( paqueteToPaqueteDTO( paquete ) );
        }

        return list;
    }

    private String paquetePaisNombrePais(Paquete paquete) {
        Pais pais = paquete.getPais();
        if ( pais == null ) {
            return null;
        }
        return pais.getNombrePais();
    }
}

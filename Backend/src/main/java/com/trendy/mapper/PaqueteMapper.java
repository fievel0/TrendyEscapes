package com.trendy.mapper;

import com.trendy.entidades.Paquete.Ciudad;
import com.trendy.entidades.Paquete.Paquete;
import com.trendy.entidades.Paquete.TipoPaquete;
import com.trendy.entidades.dtos.paquete.PaqueteDTO;
import com.trendy.entidades.enums.TipoPaqueteEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaqueteMapper {


   @Mapping(target = "nombre", source = "nombrePaquete")
   @Mapping(target = "id", source = "idPaquete")
   @Mapping(target = "costo", source = "costoPaquete")
   @Mapping(target = "ciudades", source = "ciudadList", qualifiedByName = "mapNombreCiudades")
   @Mapping(target = "pais", source = "pais.nombrePais")
   @Mapping(target = "tipoPaquete", source = "tipoPaquete", qualifiedByName = "mapTipoPaquete")
   PaqueteDTO paqueteToPaqueteDTO(Paquete paquete);

    List<PaqueteDTO> paquetesToPaquetesDTO(List<Paquete> paquetes);

    @Named("mapNombreCiudades")
    default List<String> mapCiudades(List<Ciudad> ciudadList){
        return ciudadList.stream()
                .map(Ciudad::getNombreCiudad)
                .collect(Collectors.toList());
    }

    @Named("mapTipoPaquete")
    default String mapTipoPaquete(TipoPaquete tipoPaquete){
        return tipoPaquete.getDescripcion().name();
    }

}

package com.trendy.controlador;

import com.trendy.entidades.dtos.paquete.PaqueteDTO;
import com.trendy.servicio.paquete.PaqueteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/paquetes")
@Tag(name = "Paquetes", description = "Operaciones sobre paquetes")
public class PaqueteController {

    private final PaqueteService paqueteService;

    @Autowired
    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @Operation(
            summary = "Obtener todos los paquetes de viaje",
            description = "Recupera una lista paginada de todos los paquetes de viaje. Permite filtrar por criterios específicos como el nombre del paquete, país, tipo de paquete, costo y si incluye hotel.",
            security = @SecurityRequirement(name = "Security Token"),
            parameters = {
                    @Parameter(name = "criteria", description = "Criterio de filtrado disponible (e.g., pais, tipoPaquete, costo, hotel)"),
                    @Parameter(name = "value", description = "Valor para el criterio de filtrado. El valor debe ser un texto para criterios como 'pais' y 'tipoPaquete', y un número para 'costo'. El valor para 'hotel' debe ser 'true' o 'false'."),
                    @Parameter(name = "page", description = "Número de página (empezando desde 0)", example = "0"),
                    @Parameter(name = "size", description = "Número de paquetes por página", example = "25"),
                    @Parameter(name = "sort", description = "Criterio de ordenamiento en el formato: propiedad(,asc|desc). El orden por defecto es ascendente por nombre", example = "nombre,asc")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Recuperación exitosa de los paquetes de viaje",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Page.class),
                            examples = @ExampleObject(
                                    name = "Respuesta de Paquetes de Viaje",
                                    summary = "Ejemplo de una respuesta exitosa",
                                    value = """
                                        {
                                            "content": [
                                                {
                                                    "id": 1,
                                                    "nombre": "Escapada Tropical",
                                                    "descripcion": "Un viaje relajante a islas tropicales.",
                                                    "costo": 1200,
                                                    "hotel": true,
                                                    "foto": "escapada_tropical.jpg",
                                                    "tipoPaquete": "LUJO",
                                                    "pais": "Brasil",
                                                    "ciudades": ["Río de Janeiro", "São Paulo"]
                                                },
                                                {
                                                    "id": 2,
                                                    "nombre": "Aventura en la Montaña",
                                                    "descripcion": "Explora las montañas con tours guiados.",
                                                    "costo": 800,
                                                    "hotel": false,
                                                    "foto": "aventura_montana.jpg",
                                                    "tipoPaquete": "AVENTURA",
                                                    "pais": "Chile",
                                                    "ciudades": ["Santiago", "Valparaíso"]
                                                }
                                            ],
                                            "pageable": {
                                                "sort": {
                                                    "sorted": true,
                                                    "unsorted": false,
                                                    "empty": false
                                                },
                                                "offset": 0,
                                                "pageNumber": 0,
                                                "pageSize": 25,
                                                "paged": true,
                                                "unpaged": false
                                            },
                                            "totalPages": 1,
                                            "totalElements": 2,
                                            "last": true,
                                            "size": 25,
                                            "number": 0,
                                            "sort": {
                                                "sorted": true,
                                                "unsorted": false,
                                                "empty": false
                                            },
                                            "first": true,
                                            "numberOfElements": 2,
                                            "empty": false
                                        }
                                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Parámetros de solicitud inválidos",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Respuesta de Solicitud Incorrecta",
                                    summary = "Ejemplo de una solicitud inválida",
                                    value = """
                                        {
                                            "status": 400,
                                            "message": "Criterio de ordenamiento inválido",
                                            "timestamp": "2024-09-19T11:10:00Z"
                                        }
                                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "No autorizado - Token de autenticación inválido o faltante",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Ejemplo No Autorizado",
                                    summary = "Ejemplo de una solicitud no autorizada debido a un token faltante o inválido",
                                    value = """
                                        {
                                            "status": 401,
                                            "message": "Token es inválido o no autorizado. Por favor ingresar nuevamente",
                                            "timestamp": "2024-09-19T11:55:00Z"
                                        }
                                        """
                            )
                    )
            )}
    )
    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<Page<PaqueteDTO>> getPaquetes(@RequestParam(name = "criteria", required = false) String criteria,
                                                        @RequestParam(name = "value", required = false) String value,
                                                        @PageableDefault(direction = Sort.Direction.ASC, size = 25)  Pageable pageable){
        Page<PaqueteDTO> paquetesEnBase = paqueteService.getAllPaquetes(pageable, criteria, value);
        return ResponseEntity.ok(paquetesEnBase);
    }

}

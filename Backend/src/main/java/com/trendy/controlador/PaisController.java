package com.trendy.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendy.entidades.Paquete.Pais;
import com.trendy.servicio.paquete.PaisService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/pais")
public class PaisController {

    private final PaisService paisService;

    @Autowired
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @Operation(
        summary = "Obtener todos los países",
        description = """
            Este endpoint permite obtener una lista de todos los países registrados en el sistema. 
            El acceso a este endpoint no requiere autenticación.
            """
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Lista de países obtenida exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Pais.class),
                examples = @ExampleObject(
                    name = "Ejemplo de lista de países",
                    summary = "Ejemplo de respuesta exitosa con varios países",
                    value = """
                        [
                            {
                                "id_Pais": 1,
                                "nombre_Pais": "Argentina"
                            },
                            {
                                "id_Pais": 2,
                                "nombre_Pais": "Chile"
                            }
                        ]
                        """
                )
            )
        )
    })
    @GetMapping("findAllP")
    public ResponseEntity<List<Pais>> getAllPaises() {
        List<Pais> paises = paisService.findAll();
        return ResponseEntity.ok(paises);
    }

    @Operation(
        summary = "Obtener un país por ID",
        description = """
            Este endpoint permite obtener la información de un país específico por su ID. 
            El acceso a este endpoint no requiere autenticación.
            """
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "País encontrado exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Pais.class),
                examples = @ExampleObject(
                    name = "Ejemplo de país encontrado",
                    summary = "Ejemplo de respuesta exitosa con la información del país",
                    value = """
                        {
                            "id_Pais": 1,
                            "nombre_Pais": "Argentina"
                        }
                        """
                )
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "País no encontrado",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    name = "País no encontrado",
                    summary = "Ejemplo de respuesta cuando el país no se encuentra",
                    value = """
                        {
                            "timestamp": "2024-09-11T00:00:00Z",
                            "status": 404,
                            "error": "No encontrado",
                            "message": "País con ID 123 no encontrado"
                        }
                        """
                )
            )
        )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable("id") Long id_Pais) {
        Optional<Pais> pais = paisService.findById(id_Pais);
        return pais.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(
        summary = "Obtener un país por nombre",
        description = """
            Este endpoint permite obtener la información de un país específico por su nombre. 
            El acceso a este endpoint no requiere autenticación.
            """
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "País encontrado exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Pais.class),
                examples = @ExampleObject(
                    name = "Ejemplo de país encontrado",
                    summary = "Ejemplo de respuesta exitosa con la información del país",
                    value = """
                        {
                            "id_Pais": 1,
                            "nombre_Pais": "Argentina"
                        }
                        """
                )
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "País no encontrado",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    name = "País no encontrado",
                    summary = "Ejemplo de respuesta cuando el país no se encuentra",
                    value = """
                        {
                            "timestamp": "2024-09-11T00:00:00Z",
                            "status": 404,
                            "error": "No encontrado",
                            "message": "País con nombre 'Chile' no encontrado"
                        }
                        """
                )
            )
        )
    })
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Pais> getPaisByNombre(@PathVariable("nombre") String nombrePais) {
        Optional<Pais> pais = paisService.findByNombrePais(nombrePais);
        return pais.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(
        summary = "Crear un nuevo país",
        description = """
            Este endpoint permite crear un nuevo país en el sistema. 
            El acceso a este endpoint no requiere autenticación.
            """
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "País creado exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Pais.class),
                examples = @ExampleObject(
                    name = "Ejemplo de país creado",
                    summary = "Ejemplo de respuesta exitosa con el país creado",
                    value = """
                        {
                            "id_Pais": 3,
                            "nombre_Pais": "Brasil"
                        }
                        """
                )
            )
        )
    })
    @PostMapping("/save")
    public ResponseEntity<Pais> createPais(@RequestBody Pais pais) {
        Pais nuevoPais = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPais);
    }

    @Operation(
        summary = "Actualizar un país existente",
        description = """
            Este endpoint permite actualizar la información de un país existente por su ID. 
            El acceso a este endpoint no requiere autenticación.
            """
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "País actualizado exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Pais.class),
                examples = @ExampleObject(
                    name = "Ejemplo de país actualizado",
                    summary = "Ejemplo de respuesta exitosa con el país actualizado",
                    value = """
                        {
                            "id_Pais": 1,
                            "nombre_Pais": "Argentina Actualizado"
                        }
                        """
                )
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "País no encontrado",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    name = "País no encontrado",
                    summary = "Ejemplo de respuesta cuando el país no se encuentra",
                    value = """
                        {
                            "timestamp": "2024-09-11T00:00:00Z",
                            "status": 404,
                            "error": "No encontrado",
                            "message": "País con ID 123 no encontrado"
                        }
                        """
                )
            )
        )
    })
    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable("id") Long id_Pais, @RequestBody Pais pais) {
        if (!paisService.findById(id_Pais).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Pais paisActualizado = paisService.save(pais);
        return ResponseEntity.ok(paisActualizado);
    }

    @Operation(
        summary = "Eliminar un país por ID",
        description = """
            Este endpoint permite eliminar un país por su ID. 
            El acceso a este endpoint no requiere autenticación.
            """
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "204",
            description = "País eliminado exitosamente"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "País no encontrado",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    name = "País no encontrado",
                    summary = "Ejemplo de respuesta cuando el país no se encuentra",
                    value = """
                        {
                            "timestamp": "2024-09-11T00:00:00Z",
                            "status": 404,
                            "error": "No encontrado",
                            "message": "País con ID 123 no encontrado"
                        }
                        """
                )
            )
        )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable("id") Long id_Pais) {
        if (!paisService.findById(id_Pais).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        paisService.deleteById(id_Pais);
        return ResponseEntity.noContent().build();
    }
}

package com.trendy.controlador;

import com.trendy.entidades.dtos.cliente.ClienteInfoDTO;
import com.trendy.servicio.cliente.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @Operation(
            summary = "Obtener información de un cliente",
            description = """
                    Este endpoint permite obtener la información de un cliente específico por su ID. 
                    El acceso a este endpoint está protegido por JWT; es necesario proporcionar un token JWT válido en el header de autorización.
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Información del cliente obtenida exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClienteInfoDTO.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo de información del cliente",
                                    summary = "Ejemplo de respuesta exitosa con la información del cliente",
                                    value = """
                        {
                            "idCliente": 1,
                            "nombre": "Juan Pérez",
                            "email": "juan.perez@ejemplo.com",
                            "documento": "9876543210",
                            "fechaNacimiento": "1990-01-01",
                            "direccion": "Calle Falsa 123",
                            "pais": "Chile",
                            "numTelefono": "1234567890"
                        }
                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cliente no encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Cliente no encontrado",
                                    summary = "Ejemplo de respuesta cuando el cliente no se encuentra",
                                    value = """
                                        {
                                            "timestamp": "2024-09-11T00:00:00Z",
                                            "status": 404,
                                            "error": "No encontrado",
                                            "message": "Cliente con ID 123 no encontrado"
                                        }
                                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "No autorizado",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Error de autenticación",
                                    summary = "Ejemplo de respuesta cuando el token JWT no es válido o no se proporciona",
                                    value = """
                                        {
                                            "timestamp": "2024-09-11T00:00:00Z",
                                            "status": 401,
                                            "error": "No autorizado",
                                            "message": "Token JWT inválido o no proporcionado"
                                        }
                                        """
                            )
                    )
            )
    })
    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public ResponseEntity<ClienteInfoDTO> getSingleClient(@PathVariable("id") Long id){

        ClienteInfoDTO infoDTO = clienteService.obtenerCliente(id);
        return ResponseEntity.ok(infoDTO);

    }

}

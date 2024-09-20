package com.trendy.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendy.entidades.dtos.paquete.PagoDTO;
import com.trendy.servicio.paquete.PagoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @Operation(
            summary = "Realizar un pago",
            description = """
                    Este endpoint permite realizar un pago basado en la información proporcionada en el cuerpo de la solicitud. 
                    El servicio procesa el pago utilizando los datos del objeto `PagoDTO`.
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pago procesado exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(
                                    name = "Respuesta exitosa",
                                    summary = "Ejemplo de respuesta exitosa tras procesar el pago",
                                    value = """
                                        {
                                            "resultado": "El pago ha sido procesado exitosamente"
                                        }
                                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Solicitud inválida",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Solicitud inválida",
                                    summary = "Ejemplo de respuesta cuando los datos del pago son inválidos",
                                    value = """
                                        {
                                            "timestamp": "2024-09-19T00:00:00Z",
                                            "status": 400,
                                            "error": "Solicitud inválida",
                                            "message": "Los datos proporcionados no son válidos"
                                        }
                                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error en el servidor",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Error en el servidor",
                                    summary = "Ejemplo de respuesta cuando ocurre un error interno en el servidor",
                                    value = """
                                        {
                                            "timestamp": "2024-09-19T00:00:00Z",
                                            "status": 500,
                                            "error": "Error en el servidor",
                                            "message": "Se produjo un error inesperado al procesar el pago"
                                        }
                                        """
                            )
                    )
            )
    })
    @PostMapping("/realizar")
    public ResponseEntity<String> realizarPago(@RequestBody PagoDTO pagoDTO) {
        String resultado = pagoService.procesarPago(pagoDTO);
        return ResponseEntity.ok(resultado);
    }
}

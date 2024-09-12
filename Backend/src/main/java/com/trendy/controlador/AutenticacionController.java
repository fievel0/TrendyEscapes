package com.trendy.controlador;

import com.trendy.config.security.bean.UserDetailsServiceImpl;
import com.trendy.entidades.dtos.autenticacion.AuthenticationDTO;
import com.trendy.entidades.dtos.autenticacion.LoginDTO;
import com.trendy.entidades.dtos.autenticacion.LoginResponseDTO;
import com.trendy.entidades.dtos.autenticacion.RegistrationDTO;
import com.trendy.entidades.dtos.cliente.ClienteInfoDTO;
import com.trendy.servicio.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private ClienteService clienteService;

    @Operation(
            summary = "Autenticar a un cliente",
            description = """
                    Este endpoint permite a un usuario autenticarse. El token JWT generado tiene una duración de 1 hora.
                            Es necesario incluir el token en el header de autorización para acceder a los demás endpoints protegidos.
                            Si el token expira, el usuario deberá iniciar sesión nuevamente.
                    """,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de autenticación del usuario",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = LoginDTO.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo de autenticación de usuario",
                                    summary = "Ejemplo de autenticación de usuario",
                                    value = """
                                        {
                                            "email": "juan.perez@ejemplo.com",
                                            "password": "PasswordSeguro!123"
                                        }
                                        """
                            )
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuario autenticado exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = LoginResponseDTO.class),
                            examples = @ExampleObject(
                                    name = "Respuesta exitosa de usuario",
                                    summary = "Ejemplo de una respuesta exitosa de autenticación",
                                    value = """
                                       {
                                            "email": "juan.perez@example.com",
                                            "message": "Usuario autenticado satisfactoriamente",
                                            "jwt": "eyJhbGciOiJIUzI1NiIsInR5cCI...",
                                            "status": "true"
                                        }
                                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Credenciales inválidas",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Credenciales incorrectas",
                                    summary = "Ejemplo de respuesta cuando las credenciales son inválidas",
                                    value = """
                                        {
                                            "timestamp": "2024-08-19T23:04:40.011+00:00",
                                            "status": 403,
                                            "error": "No autorizado",
                                            "message": "Error de validación: Contraseña invalida.",
                                        }
                                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Solicitud incorrecta",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Falta el campo de nombre de usuario",
                                    summary = "Ejemplo de una respuesta cuando el cuerpo de la solicitud es inválido",
                                    value = """
                                            {
                                              "timeStamp": "2024-08-30 10:55:57",
                                              "email": "no debe estar vacío",
                                              "documento": "El número de documento debe tener exactamente 10 caracteres.",
                                              "pais": "Pais no puede estar vacio",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            )
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginDTO loginDTO){
        return new ResponseEntity<>(userDetailsService.loginUser(loginDTO), HttpStatus.OK);
    }


    @Operation(
            summary = "Registrar un nuevo cliente",
            description = "Este endpoint es público y permite a los nuevos usuarios registrarse en la plataforma.\n" +
                    "        No se requiere un token JWT para acceder a este endpoint.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de registro del cliente",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RegistrationDTO.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo de registro de cliente",
                                    summary = "Ejemplo de un registro de cliente",
                                    value = """
                        {
                            "nombre": "Juan Pérez",
                            "telefono": "1234567890",
                            "documento": "9876543210",
                            "fechaNacimiento": "1990-01-01",
                            "pais": "Chile",
                            "direccion": "Calle Chilena 123",
                            "autenticacion": {
                                "email": "juan.perez@ejemplo.com",
                                "password": "PasswordSeguro!123"
                            }
                        }
                        """
                            )
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Cliente creado exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClienteInfoDTO.class),
                            examples = @ExampleObject(
                                    name = "Respuesta exitosa del cliente",
                                    summary = "Ejemplo de un cliente creado exitosamente",
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
                    responseCode = "400",
                    description = "Entrada inválida, objeto inválido",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Respuesta de entrada inválida",
                                    summary = "Ejemplo de un error de entrada inválida",
                                    value = """
                        {
                            "status": 400,
                            "mensaje": "Formato de email inválido o campos obligatorios vacíos",
                            "timestamp": "2024-08-29T10:50:00Z"
                        }
                        """
                            )
                    )
            )
    })
    @PostMapping("/register")
    public ResponseEntity<ClienteInfoDTO> registerUser(@RequestBody @Valid RegistrationDTO registrationDTO,
                                                       UriComponentsBuilder uriComponentsBuilder){

        ClienteInfoDTO clienteInfoDTO =  userDetailsService.registerUser(registrationDTO);

        URI url = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(clienteInfoDTO.idCliente()).toUri();

        return ResponseEntity.created(url).body(clienteInfoDTO);

    }


    @Operation(
            summary = "Prueba de seguridad JWT",
            description = """
                    Este endpoint está protegido por JWT. Si el token JWT proporcionado en el header de autorización es válido,
                    se devuelve el mensaje 'Valid JWT token!!!'. De lo contrario, se deniega el acceso.
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Token JWT válido",
                    content = @Content(
                            mediaType = "text/plain",
                            examples = @ExampleObject(
                                    name = "Mensaje de éxito",
                                    summary = "Ejemplo de respuesta cuando el token JWT es válido",
                                    value = "Valid JWT token!!!"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Token JWT inválido o no proporcionado",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Error de autenticación",
                                    summary = "Ejemplo de respuesta cuando el token JWT no es válido o no se proporciona",
                                    value = """
                                            {
                                                "error": "Unauthorized",
                                                "details": "Token es inválido o no autorizado. Por favor ingresar nuevamente",
                                                "timestamp": "2024-09-11 18:42:36"
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping("/test")
    public String testSecured(){
        return "Valid JWT token!!!";
    }



}

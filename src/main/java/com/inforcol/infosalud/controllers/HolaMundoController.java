package com.inforcol.infosalud.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping ("/api")
@Tag(name = "hola")
//@PreAuthorize("permitAll()")
@PreAuthorize("isAuthenticated()")
public class HolaMundoController {

    private static final Logger logger = LoggerFactory.getLogger(HolaMundoController.class);

    @Operation(
            summary = "Metodo de bienvenida",
            description = "Metodo que ofrece un mensaje de bienvenida.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful authentication"
                    )
            }
    )
    @GetMapping("/hola")
    public String holaMundo(@RequestParam(name = "nombre") String nombre) {

        logger.info("Se esta saludando a: " + nombre);

        return "¡Hola " + nombre + "!";
    }
}

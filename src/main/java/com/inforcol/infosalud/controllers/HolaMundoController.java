package com.inforcol.infosalud.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping ("/api")
@Tag(name = "hola")
public class HolaMundoController {

    private static final Logger logger = LoggerFactory.getLogger(HolaMundoController.class);

    @Operation(summary = "Metodo de bienvenida")
    @GetMapping("/hola")
    public String holaMundo(@RequestParam(name = "nombre") String nombre) {

        logger.info("Se esta saludando a: " + nombre);

        return "¡Hola " + nombre + "!";
    }

}

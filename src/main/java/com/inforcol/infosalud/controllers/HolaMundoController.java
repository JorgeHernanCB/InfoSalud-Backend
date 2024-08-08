package com.inforcol.infosalud.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api")
@Tag(name = "hola")
public class HolaMundoController {

    @Operation(summary = "Metodo de bienvenida")
    @GetMapping("/hola")
    public String holaMundo(@RequestParam(name = "nombre") String nombre) {
        return "¡Hola " + nombre;
    }

}

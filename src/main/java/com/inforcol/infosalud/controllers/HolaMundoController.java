package com.inforcol.infosalud.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
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

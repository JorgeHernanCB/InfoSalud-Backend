package com.inforcol.infosalud.controllers;

import com.inforcol.infosalud.entities.DTO.UserDto;
import com.inforcol.infosalud.entities.Users;
import com.inforcol.infosalud.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
@Tag(name = "Usuario")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Operation(
        summary = "Obtener todo",
        description = "Metodo que obtiene todos los registros."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = UserDto.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/findAll")
    public ResponseEntity<List<UserDto>> findAll(){
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @Operation(
        summary = "Obtener un solo registro",
        description = "Metodo que obtiene un solo registro, buscandolo por IP.",
        responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful authentication"
            )
        }
    )
    @GetMapping("/find/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        logger.debug("ID a buscar: " + id);
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Insertar Usuario",
            description = "Metodo que inserta un usuario.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful authentication"
                    )
            }
    )
    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        logger.debug("Usario a insertar: " + userDto.toString());
        return new ResponseEntity<>(this.userService.save(userDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Actualizar Usuario",
            description = "Metodo que actualiza un usuario ya existente.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful authentication"
                    )
            }
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> save(@PathVariable Long id, @RequestBody UserDto users){
        logger.debug("ID de usuario a actualizar: " + id);
        logger.debug("Usario a actualizar: " + users.toString());
        return new ResponseEntity<>(this.userService.updateUser(id, users), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Eliminar Usuario",
            description = "Metodo que elimina un usuario.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful authentication"
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        logger.debug("ID de usuario a eliminar: " + id);
        return new ResponseEntity<>(this.userService.deleteUser(id), HttpStatus.OK);
    }

}

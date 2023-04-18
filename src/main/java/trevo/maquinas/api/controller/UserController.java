package trevo.maquinas.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trevo.maquinas.api.model.User;
import trevo.maquinas.api.security.AuthenticationDTO;
import trevo.maquinas.api.service.UserService;

@RestController
@RequestMapping("user")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Registro de usuário", tags = "User" , security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<?> register(@RequestBody @Valid User dados) {
        return userService.register(dados);
    }
    @GetMapping(value = "/list")
    @Operation(summary = "Listar usuário", tags = "User" , security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<?> list() {
        return userService.list();
    }
    @DeleteMapping ("/delete/{id}")
    @Operation(summary = "Deleta um usuário", tags = "User" , security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return userService.delete(id);
    }
    @PutMapping ("/update/{id}")
    @Operation(summary = "Atualiza o usuário", tags = "User" , security = {@SecurityRequirement(name = "bearer-key")})
    @Transactional
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid User dados) {
        return userService.update(id, dados);
    }
    @PostMapping(value = "/login")
    @Operation(summary = "Efetua login de usuário", tags = "User")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO dto) {
        return userService.token(dto);
    }
}

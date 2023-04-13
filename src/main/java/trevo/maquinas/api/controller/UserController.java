package trevo.maquinas.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trevo.maquinas.api.model.User;
import trevo.maquinas.api.security.AuthenticationDTO;
import trevo.maquinas.api.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("user")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody @Valid User dados) {
        return userService.register(dados);
    }
    @GetMapping(value = "/list")
    public ResponseEntity<?> list() {
        return userService.list();
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return userService.delete(id);
    }
    @PutMapping ("/update/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid User dados) {
        return userService.update(id, dados);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO dto) {
        return userService.token(dto);
    }
}

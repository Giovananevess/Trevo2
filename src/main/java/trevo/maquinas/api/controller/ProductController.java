package trevo.maquinas.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trevo.maquinas.api.dto.ProductDadosDTO;
import trevo.maquinas.api.service.ProductService;
import java.util.UUID;

@RestController
@RequestMapping("product")

public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody @Valid ProductDadosDTO dto) {
        return productService.register(dto);
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return productService.list();
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return productService.delete(id);
    }

    @PutMapping ("/update/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid ProductDadosDTO dto) {
        return productService.update(id, dto);
    }
}

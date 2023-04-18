package trevo.maquinas.api.controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Registrar um novo produto", tags = "Produto")
    public ResponseEntity<?> register(@RequestBody @Valid ProductDadosDTO dto) {
        return productService.register(dto);
    }

    @GetMapping
    @Operation(summary = "Listar todos os produtos já cadastrados", tags = "Produto")
    public ResponseEntity<?> list() {
        return productService.list();
    }

    @DeleteMapping ("/delete/{id}")
    @Operation(summary = "Deletar um produto", tags = "Produto")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return productService.delete(id);
    }

    @PutMapping ("/update/{id}")
    @Transactional
    @Operation(summary = "Atualizar um produto", tags = "Produto")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid ProductDadosDTO dto) {
        return productService.update(id, dto);
    }
}

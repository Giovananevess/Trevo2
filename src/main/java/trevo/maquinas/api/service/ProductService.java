package trevo.maquinas.api.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import trevo.maquinas.api.dto.ProductDadosDTO;
import trevo.maquinas.api.model.Product;
import trevo.maquinas.api.repository.ProductRepository;
import trevo.maquinas.api.response.ResponseModelMessage;
import trevo.maquinas.api.response.ResponseModelObject;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<?> register(@RequestBody @Valid ProductDadosDTO dto) {
        Product product = new Product(dto);
        productRepository.save(product);
        return new ResponseEntity<>(new ResponseModelObject("Produto cadastrado", product), HttpStatus.OK);
    }

    public ResponseEntity<?> list() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()){
            return new ResponseEntity<>(new ResponseModelMessage("Lista de produto está vazia"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseModelObject("Lista de produtos", products), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(UUID id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ResponseEntity<>(new ResponseModelMessage("Produto foi deletado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseModelMessage("Produto não encontrado"), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid ProductDadosDTO dto) {
        Product product = productRepository.findById(id).orElse(null);
        if (productRepository.existsByName(dto.name())) {
            return new ResponseEntity<>(new ResponseModelMessage("Produto com nome " + dto.name() + " já existe"), HttpStatus.BAD_REQUEST);
        }
        if (!productRepository.existsById(id) || product == null) {
            return new ResponseEntity<>(new ResponseModelMessage("Produto não encontrado"), HttpStatus.BAD_REQUEST);
        }
        product.update(dto);
        productRepository.save(product);
        return new ResponseEntity<>(new ResponseModelObject("Produto atualizado", product), HttpStatus.OK);
    }
}

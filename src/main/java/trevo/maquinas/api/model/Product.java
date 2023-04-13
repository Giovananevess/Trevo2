package trevo.maquinas.api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trevo.maquinas.api.dto.CategoryEnum;
import trevo.maquinas.api.dto.ProductDadosDTO;
import trevo.maquinas.api.dto.StatusEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Table(name = "tb_product")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private Double price;

    private String description;

    private CategoryEnum category;

    private StatusEnum status;

    private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public Product(ProductDadosDTO dto) {
        this.name = dto.name();
        this.description = dto.description();
        this.price = dto.price();
        this.category = dto.category();
        this.status = StatusEnum.DISPONIVEL;
    }

    public void update(ProductDadosDTO dto) {
        if (dto.name() != null) {
            this.name = dto.name();
        }
        if (dto.price() != null) {
            this.price = dto.price();
        }
        if (dto.description() != null) {
            this.description = dto.description();
        }
        if (dto.status() != null) {
            this.status = dto.status();
        }
    }

}


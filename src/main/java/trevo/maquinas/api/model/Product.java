package trevo.maquinas.api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "price", unique = true, nullable = false)
    private Double price;

    @Column(name = "description", unique = true, nullable = false, columnDefinition = "Text")
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Enumerated(EnumType.STRING)
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


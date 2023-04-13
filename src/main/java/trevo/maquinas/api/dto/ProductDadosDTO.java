package trevo.maquinas.api.dto;


import jakarta.validation.constraints.NotEmpty;


public record ProductDadosDTO(
        @NotEmpty(message = "O campo de nome não pode estar vazio")
        String name,

        @NotEmpty(message = "O campo de descrição não pode estar vazio")
        String description,

        Double price,


        StatusEnum status,


        CategoryEnum category
) {
}

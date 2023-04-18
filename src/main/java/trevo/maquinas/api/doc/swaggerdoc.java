package trevo.maquinas.api.doc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerdoc {
    @Bean
    public OpenAPI swagger() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info().title("Trevo agro API")
                        .description("Este projeto foi criado com intuito efetuar cadastros e consultas de produtos oferecidos pela industria Trevo. <br>" +
                                        "Com esta api, os usuários poderão consultar informações sobre os produtos. <br> " +
                                        "Possibilitando a requisição de orçamentos dos produtos disponibilizados pela empresa.<br>" +
                                        "Para acessar repositorio do projeto acesse " +
                                        "<a target=\"_blank\" href=\"https://github.com/Giovananevess\">Giovana Neves</a>"
                        ));
    }
}

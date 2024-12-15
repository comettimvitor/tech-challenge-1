package br.com.atividade1.atividade1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI techChallenge1() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tech Challenge 1 - API para Restaurantes")
                        .description("Primeiro Tech Challenge da FIAP do curso de Arquitetura e Desenvolvimento Java.\n" +
                                "API de cadastro de usuarios (clientes e donos de restaurante) para um sistema compartilhado de restaurantes.")
                        .version("v 0.0.1")
                        .license(new License().name("Repositorio Github").url("https://github.com/comettimvitor")));
    }
}

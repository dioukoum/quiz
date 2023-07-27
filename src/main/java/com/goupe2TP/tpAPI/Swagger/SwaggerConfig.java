package com.goupe2TP.tpAPI.Swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI SwaggerConfig() {
        return new OpenAPI()
                .info(new Info().title("API POUR LE QUIZ")
                        .description("Tout les endpoint pour cette Api")
                        .version("1.0"));
    }
}

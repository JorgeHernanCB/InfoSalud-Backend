package com.inforcol.infosalud.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "InfoSalud",
                version = "1.0.0",
                description = "App de infoSalud INFORCOL"
        )
)
public class SwaggerConfig {

        @Bean
        public Docket api() {
                return new Docket(DocumentationType.OAS_30)  // Utiliza OAS_30 para OpenAPI 3.0
                        .select()
                        .apis(RequestHandlerSelectors.any())
                        .paths(PathSelectors.any())
                        .build();
        }

}

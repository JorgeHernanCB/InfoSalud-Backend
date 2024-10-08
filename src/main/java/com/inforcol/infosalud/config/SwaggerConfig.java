package com.inforcol.infosalud.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "InfoSalud",
                description = "App de infoSalud INFORCOL",
                termsOfService = "www.unprogramadornace.com/terminos_y_condiciones",
                version = "1.0.0",
                contact = @Contact(
                        name = "Inforcol S.A.",
                        url = "https://co.linkedin.com/company/inforcolserviciosinformaticos",
                        email = "jcastano@inforcol.com"
                ),
                license = @License(
                        name = "Standard Software Use License for Inforcol S.A.",
                        url = "www.inforccol.com/licence"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://produccion:8080"
                )
        },
        security = @SecurityRequirement(
                name = "Security Token"
        )
)
public class SwaggerConfig {

}

package uz.atm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import uz.atm.properties.DSQApiProperties;
import uz.atm.properties.OpenApiProperties;

/**
 * @author Shoxruh Bekpulatov
 * Time : 11/02/23
 */
@OpenAPIDefinition
@EnableConfigurationProperties(value = {
        DSQApiProperties.class,
        OpenApiProperties.class
})
@Configuration
public class BaseConfig {
    private final DSQApiProperties dsqApiProperties;

    public BaseConfig( DSQApiProperties dsqApiProperties ) {
        this.dsqApiProperties = dsqApiProperties;
    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean("dsq-webclient-minfin")
    WebClient webClient() {
        return WebClient.builder()
                .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs()
                        .maxInMemorySize(1000 * 1024))
                .baseUrl(dsqApiProperties.getUrl().getProtocol() + dsqApiProperties.getUrl().getDomain())
                .build();

    }


}

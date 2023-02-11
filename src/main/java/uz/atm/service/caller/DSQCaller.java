package uz.atm.service.caller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import uz.atm.dto.AppErrorDto;
import uz.atm.dto.DataDto;
import uz.atm.dto.LoginDto;
import uz.atm.properties.DSQApiProperties;
import uz.atm.utils.Session;

import java.util.Objects;

import static uz.atm.utils.AppUtils.isJWT;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 16:23
 */
@Service
@Slf4j
public class DSQCaller {

    private final DSQApiProperties dsqApiProperties;
    private final WebClient webClient;

    public DSQCaller( DSQApiProperties dsqApiProperties, @Qualifier("dsq-webclient-minfin") WebClient webClient ) {
        this.dsqApiProperties = dsqApiProperties;
        this.webClient = webClient;
    }

    public void loginCall() {
        LoginDto loginDto = new LoginDto(dsqApiProperties.getUser(), dsqApiProperties.getPassword());
        try {
            String token = webClient.post()
                    .uri(dsqApiProperties.getUrl().getPath().getLoginAPI())
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(loginDto)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            if ( isJWT(Objects.requireNonNull(token)) )
                Session.INSTANCE.setValue(token);
        } catch ( Exception e ) {
            Session.INSTANCE.setValue(null);
            log.error("Exception occurred authorizing with DSQ : Cause :{} ", e.getMessage());
        }
    }

    private void checkLoggedIn() {
        if ( Objects.isNull(Session.INSTANCE.getValue()) )
            this.loginCall();
    }


    public <RES> DataDto<RES> getCall( MultiValueMap<String, String> params, String endpoint, ParameterizedTypeReference<RES> typeReference ) {
        checkLoggedIn();
        try {
            RES response = webClient.get()
                    .uri(uriBuilder -> uriBuilder.path(endpoint).queryParams(params).build())
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + Session.INSTANCE.getValue())
                    .retrieve()
                    .bodyToMono(typeReference)
                    .block();
            return new DataDto<>(response);
        } catch ( Exception e ) {
            log.error("Exception Occurred calling DSQ : params : {} ; Cause {}", StringUtils.join(params, ','), e.getMessage());
            return new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    public <RES> DataDto<RES> getCall( MultiValueMap<String, String> params, String endpoint, Class<RES> responseType ) {
        checkLoggedIn();
        try {
            RES response = webClient.get()
                    .uri(uriBuilder -> uriBuilder.path(endpoint).queryParams(params).build())
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + Session.INSTANCE.getValue())
                    .retrieve()
                    .bodyToMono(responseType)
                    .block();
            return new DataDto<>(response);
        } catch ( Exception e ) {
            log.error("Exception Occurred calling DSQ : params : {} ; Cause {}", StringUtils.join(params, ','), e.getMessage());
            return new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }


    public <RES> DataDto<RES> postCall( Object body, String endpoint, ParameterizedTypeReference<RES> typeReference ) {
        checkLoggedIn();
        try {
            RES response = webClient.post()
                    .uri(endpoint)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + Session.INSTANCE.getValue())
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(typeReference)
                    .block();
            return new DataDto<>(response);
        } catch ( Exception e ) {
            log.error("Exception Occurred calling DSQ : Request : {} ; Cause {}", body.toString(), e.getMessage());
            return new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    public <RES> DataDto<RES> postCall( Object body, String endpoint, Class<RES> responseType ) {
        checkLoggedIn();
        try {
            RES response = webClient.post()
                    .uri(endpoint)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + Session.INSTANCE.getValue())
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(responseType)
                    .block();
            return new DataDto<>(response);
        } catch ( Exception e ) {
            log.error("Exception Occurred calling DSQ : Request : {} ; Cause {}", body.toString(), e.getMessage());
            return new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }
}

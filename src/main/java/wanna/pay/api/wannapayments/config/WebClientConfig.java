package wanna.pay.api.wannapayments.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


    @Value("${wgp.api.url}")
    private String wgpApiUrl;

    @Value("${pay.key}")
    private String payKey;


    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
         .baseUrl(wgpApiUrl)
         .defaultHeaders(httpHeaders -> {
             httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
             httpHeaders.add(HttpHeaders.AUTHORIZATION, payKey);
         })
         .build();
    }
}

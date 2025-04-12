package live.tikgik.bank.gatetwayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator tikGikRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(pred -> pred.path("/tikgik/account/**")
                        .filters(filter ->
                                filter
                                .rewritePath("/tikgik/account/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://ACCOUNT"))
                .route(pred -> pred.path("/tikgik/bank/**")
                        .filters(filter ->
                                filter
                                        .rewritePath("/tikgik/bank/(?<segment>.*)","/${segment}")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://BANK"))
                .route(pred -> pred.path("/tikgik/card/**")
                        .filters(filter ->
                                filter
                                        .rewritePath("/tikgik/card/(?<segment>.*)","/${segment}")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CARD"))
                .build();

    }
}

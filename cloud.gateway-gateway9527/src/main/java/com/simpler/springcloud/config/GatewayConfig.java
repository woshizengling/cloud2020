package com.simpler.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/09 20:36
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_rote_simpler",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();


        return routes.build();
    }

}

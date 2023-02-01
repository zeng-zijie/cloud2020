package com.zichun.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/1 13:10
 */
@Configuration
public class GetWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zichun_1",
                r->r.path("/dance").uri("https://www.bilibili.com/v/dance")).build();

        return routes.build();
    }
}

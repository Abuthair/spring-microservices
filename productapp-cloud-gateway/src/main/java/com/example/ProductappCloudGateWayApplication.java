package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductappCloudGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappCloudGateWayApplication.class, args);
	}




//@Bean
//	//create our own routes- programmatically
//RouteLocator customRoutes(RouteLocatorBuilder builder){
//
//		return builder.routes()
//           //create individual routes with id,uri,pridicate(path),filters
//				.route("productservice",predicateSpec -> predicateSpec.path("/product-api/**").uri("lb://PRODUCT-SERVICE"))
//               //FOR CART Service
//				.route("cartService",predicateSpec -> predicateSpec.path("/cart-api/**").uri("lb://CART-SERVICE"))
//				//FOR ORDER SERVICE
//				.route("orderService",predicateSpec -> predicateSpec.path("/order-api/**").uri("ln://ORDER-SERVICE"))
//				.build();

}



package com.employee_management.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.WebGraphQlClient;
import org.springframework.graphql.client.WebSocketGraphQlClient;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.graphql.client.WebSocketGraphQlClient;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import java.net.URI;

@Configuration
public class GraphQLConfig {


    @Bean
    public GraphQLScalarType longScalar() {
        return ExtendedScalars.GraphQLLong;
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.GraphQLLong);
    }



    @Bean
    public WebSocketGraphQlClient webSocketGraphQlClient() {
        WebSocketClient webSocketClient = new ReactorNettyWebSocketClient();

        // Define the WebSocket URI
        URI uri = URI.create("ws://localhost:9100/apis/graphql");

        // Build and return the WebSocketGraphQlClient with the custom client and URI
        return WebSocketGraphQlClient.builder(uri, webSocketClient).build();
    }

//    @Bean
//    public GraphQlHttpHandler graphQlHttpHandler(WebGraphQlHandler handler) {
//        return GraphQlHttpHandler.builder(handler).build();
//    }
}

package org.example.client.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    @Bean
    public ManagedChannel gRpcServerManagedChannel() {
        return  ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .build();
    }
}

package org.example.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.example.client.service.GreeterClient;
import org.example.grpc.helloworld.HelloReply;
import org.example.grpc.helloworld.HelloRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class GrpcClientApplication implements CommandLineRunner {

    private final GreeterClient greeterClient;

    public GrpcClientApplication(GreeterClient greeterClient) {
        this.greeterClient = greeterClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        HelloReply reply = greeterClient.getGreeterBlockingStub().sayHello(HelloRequest.newBuilder().setName("gRPC Client").build());
        log.info("Reply: {}", reply);
    }

}

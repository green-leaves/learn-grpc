package org.example.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.example.grpc.helloworld.GreeterGrpc;
import org.example.grpc.helloworld.HelloReply;
import org.example.grpc.helloworld.HelloRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GrpcClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ManagedChannel localhost = ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(localhost);

        HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName("gRPC Client").build());
        log.info("Reply: {}", reply);
    }
}

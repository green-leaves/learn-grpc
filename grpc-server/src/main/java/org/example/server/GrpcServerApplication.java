package org.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.example.server.service.GreeterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GrpcServerApplication implements CommandLineRunner {

    private final GreeterService greeterService;

    public static void main(String[] args) {
        SpringApplication.run(GrpcServerApplication.class, args);
    }

    public GrpcServerApplication(GreeterService greeterService) {
        this.greeterService = greeterService;
    }

    @Override
    public void run(String... args) throws Exception {
        int port = 9000;
        final Server server = ServerBuilder.forPort(port)
                .addService(greeterService)
                .build()
                .start();

        log.info("gRPC server started at port {}", port);
    }
}

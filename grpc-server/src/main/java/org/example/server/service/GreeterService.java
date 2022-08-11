package org.example.server.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.example.grpc.helloworld.GreeterGrpc;
import org.example.grpc.helloworld.HelloReply;
import org.example.grpc.helloworld.HelloRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    private final HostNameHelper hostNameHelper;

    public GreeterService(HostNameHelper hostNameHelper) {
        this.hostNameHelper = hostNameHelper;
    }

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(String.format("Hello %s from %s", request.getName(), hostNameHelper.determineHostname()))
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}

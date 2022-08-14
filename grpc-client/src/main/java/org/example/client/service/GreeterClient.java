package org.example.client.service;

import io.grpc.ManagedChannel;
import lombok.Getter;
import org.example.grpc.helloworld.GreeterGrpc;
import org.springframework.stereotype.Service;

@Getter
@Service
public class GreeterClient {

    private final ManagedChannel gPrcServerManagedChannel;

    private final GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    public GreeterClient(ManagedChannel gPrcServerManagedChannel) {
        this.gPrcServerManagedChannel = gPrcServerManagedChannel;
        this.greeterBlockingStub = GreeterGrpc.newBlockingStub(gPrcServerManagedChannel);
    }

}

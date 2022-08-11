package org.example.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;

@Slf4j
@Component
public class HostNameHelper {

    public String determineHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (IOException ex) {
            log.info( "Failed to determine hostname. Will generate one", ex);
        }
        // Strange. Well, let's make an identifier for ourselves.
        return "generated-" + new Random().nextInt();
    }
}

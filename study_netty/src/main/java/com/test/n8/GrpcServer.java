package com.test.n8;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer server = new GrpcServer();
        server.start();
        server.awaitTermination();
    }

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build();
        this.server.start();
    }

    private void stop() {
        this.server.shutdown();
    }

    private void awaitTermination() throws InterruptedException {
        if (this.server != null) {
            this.server.awaitTermination();
        }
    }
}

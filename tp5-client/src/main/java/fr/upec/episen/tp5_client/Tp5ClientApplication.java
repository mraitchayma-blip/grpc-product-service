package fr.upec.episen.tp5_client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.upec.episen.tp5_server.ProductServiceGrpc;
import fr.upec.episen.tp5_server.ProductServiceGrpc.ProductServiceBlockingStub;
import fr.upec.episen.tp5_server.ProductServiceOuterClass.GetProductRequest;
import fr.upec.episen.tp5_server.ProductServiceOuterClass.GetProductResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class Tp5ClientApplication implements CommandLineRunner {

    protected Logger logger = LoggerFactory.getLogger(Tp5ClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Tp5ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Starting the gRPC client");

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8181)
                .usePlaintext()
                .build();

        ProductServiceBlockingStub productServiceBlockingStub =
                ProductServiceGrpc.newBlockingStub(channel);

        GetProductRequest request = GetProductRequest.newBuilder()
                .setId(1)
                .build();

        GetProductResponse response =
                productServiceBlockingStub.getProduct(request);

        logger.info("Received product: " + response);

        logger.info("product = " +
                response.getName() + " - " +
                response.getPrice());

        channel.shutdown();
    }
}
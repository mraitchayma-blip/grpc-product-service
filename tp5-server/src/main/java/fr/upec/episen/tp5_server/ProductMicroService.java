package fr.upec.episen.tp5_server;

import java.util.List;

import fr.upec.episen.tp5_server.ProductServiceGrpc.ProductServiceImplBase;
import fr.upec.episen.tp5_server.ProductServiceOuterClass.GetProductRequest;
import fr.upec.episen.tp5_server.ProductServiceOuterClass.GetProductResponse;
import fr.upec.episen.tp5_server.ProductServiceOuterClass.ListProductsRequest;
import fr.upec.episen.tp5_server.ProductServiceOuterClass.ListProductsResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class ProductMicroService extends ProductServiceImplBase{
    protected List<Product> products;

    public ProductMicroService() {
        super();
// Initialize the list of products
        products = List.of(
            new Product(1, "Product 1", 10.0),
            new Product(2, "Product 2", 20.0),
            new Product(3, "Product 3", 30.0)
        );
    }

    @Override
    public void getProduct(GetProductRequest request, StreamObserver<GetProductResponse> responseObserver) {
        int productId = request.getId();
        Product product = products.stream()
            .filter(p -> p.getId() == productId)
            .findFirst()
            .orElse(null);
        GetProductResponse response = null;
        if (product != null) {
            response = GetProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setPrice(product.getPrice())
                .build();
        } else {
            response = GetProductResponse.newBuilder().build(); // Return an empty response if product not found
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void listProducts(ListProductsRequest request, StreamObserver<ListProductsResponse> responseObserver) {
        ListProductsResponse.Builder responseBuilder = ListProductsResponse.newBuilder();
        request.getIdsList().forEach(id -> {
            Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
            if (product != null) {
                GetProductResponse response = GetProductResponse.newBuilder()
                    .setId(product.getId())
                    .setName(product.getName())
                    .setPrice(product.getPrice())
                    .build();
                responseBuilder.addProducts(response);
            }
        }); 
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}

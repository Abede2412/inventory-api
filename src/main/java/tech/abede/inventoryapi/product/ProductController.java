package tech.abede.inventoryapi.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponse> createOne(@RequestBody ProductRequest productRequest){
        Product product = productRequest.convertToEntity();
        Product saveProduct = this.productService.createOne(product);
        return ResponseEntity.status(201).body(saveProduct.convertToResponse());
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getAll(@RequestParam("name") Optional<String> optionalName){
        List<Product> products = this.productService.getAll(optionalName);
        List<ProductResponse> productResponses = products.stream().map(Product::convertToResponse).toList();
        return  ResponseEntity.ok().body(productResponses);
    }


}

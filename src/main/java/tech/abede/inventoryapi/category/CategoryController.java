package tech.abede.inventoryapi.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.abede.inventoryapi.product.Product;
import tech.abede.inventoryapi.product.ProductResponseByCategory;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories/{name}/products")
    public ResponseEntity<List<ProductResponseByCategory>> getProductsByCategory(@PathVariable("name") String name){
        Category category = this.categoryService.findOneByNameIgnoreCase(name);
        List<ProductResponseByCategory> products = category.getProducts().stream().map(Product::convertToResponseByCategory).toList();
        return ResponseEntity.ok().body(products);
    }
}

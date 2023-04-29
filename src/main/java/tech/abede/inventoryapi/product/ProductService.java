package tech.abede.inventoryapi.product;

import org.springframework.stereotype.Service;
import tech.abede.inventoryapi.category.Category;
import tech.abede.inventoryapi.category.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> getAll(Optional<String> optionalName){
        if (optionalName.isPresent()){
            return this.productRepository.findByNameIgnoreCase(optionalName.get());
        }
        return this.productRepository.findAll();
    }
    public Product createOne(Product product){
        setCategoryOfProduct(product);
        return this.productRepository.save(product);
    }
    private void setCategoryOfProduct(Product product) {
        Category category = product.getCategory();
        Category existingCategory = this.categoryService.findOneByNameIgnoreCase(category.getName());
        if(existingCategory == null){
            Category newCategory = this.categoryService.createOne(category);
            product.setCategory(newCategory);
        } else {
            product.setCategory(existingCategory);
        }
    }
}

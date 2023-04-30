package tech.abede.inventoryapi.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import tech.abede.inventoryapi.category.Category;

public class ProductRequest {

    @NotBlank(message = "Product name can't be blank")
    private String name;
    @PositiveOrZero(message = "Product quantity must be positive or zero")
    private Integer quantity;
    @NotBlank(message = "Product category can't be blank")
    private String category;

    public ProductRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product convertToEntity() {
        Product product = new Product();
        product.setQuantity(this.quantity);
        product.setName(this.name);
        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);
        return product;
    }
}

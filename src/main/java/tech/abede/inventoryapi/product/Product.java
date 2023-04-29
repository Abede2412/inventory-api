package tech.abede.inventoryapi.product;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tech.abede.inventoryapi.category.Category;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private Integer quantity;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Product() {
    }
    public ProductResponse convertToResponse(){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(this.id);
        productResponse.setName(this.name);
        productResponse.setQuantity(this.quantity);
        productResponse.setCategory(this.category.getName());
        return productResponse;
    }
    public ProductResponseByCategory convertToResponseByCategory(){
        ProductResponseByCategory productResponse = new ProductResponseByCategory();
        productResponse.setId(this.id);
        productResponse.setName(this.name);
        productResponse.setQuantity(this.quantity);
        return productResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

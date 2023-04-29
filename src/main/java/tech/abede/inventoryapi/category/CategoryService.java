package tech.abede.inventoryapi.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createOne (Category category){
        return this.categoryRepository.save(category);
    }
}

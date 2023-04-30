package tech.abede.inventoryapi.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Category Not Found")
public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException() {

    }
}

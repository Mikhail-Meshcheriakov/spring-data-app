package ru.geekbrains.spring.data.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.data.model.Product;
import ru.geekbrains.spring.data.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false) Integer min, @RequestParam(required = false) Integer max) {
        if (min != null && max != null) {
            return productRepository.findAllByPriceBetween(min, max);
        }
        if (min != null) {
            return productRepository.findAllByPriceGreaterThanEqual(min);
        }
        if (max != null) {
            return productRepository.findAllByPriceLessThanEqual(max);
        }
        return (List<Product>) productRepository.findAll();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}

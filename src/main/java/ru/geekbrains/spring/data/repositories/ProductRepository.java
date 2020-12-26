package ru.geekbrains.spring.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.data.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThanEqual(Integer price);

    List<Product> findAllByPriceLessThanEqual(Integer price);

    List<Product> findAllByPriceBetween(Integer min, Integer max);
}

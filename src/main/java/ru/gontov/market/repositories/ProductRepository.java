package ru.gontov.market.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gontov.market.entities.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}

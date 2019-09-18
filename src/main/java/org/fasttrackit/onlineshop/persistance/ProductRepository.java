package org.fasttrackit.onlineshop.persistance;

import org.fasttrackit.onlineshop.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContaining(String PartialName, Pageable pageable);
    Page<Product> findByNameContainingAndQuantityGreaterThanEqual(String PartialName, int minimumQuantity,Pageable pageable);
    //jpql-Java Persistence Query Language
    //named query
    //@Query("SELECT product FROM Product product WHERE name LIKE ':partialName' ")
    @Query(value = "SELECT * FROM product WHERE name LIKE '%?1%' " ,nativeQuery = true)
    List<Product> findByPartialName(String partialName);

}

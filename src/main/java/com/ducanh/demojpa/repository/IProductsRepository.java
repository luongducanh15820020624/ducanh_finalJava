package com.ducanh.demojpa.repository;

import com.ducanh.demojpa.entity.Catalogs;
import com.ducanh.demojpa.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductsRepository extends JpaRepository<Products, Long> {
    List<Products> findByCatalog(Catalogs catalog);
}

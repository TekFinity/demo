package com.example.firstProject.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends CrudRepository<STOCK_ITEM, Integer> {
    public STOCK_ITEM findBySkuId(String skuId);

}

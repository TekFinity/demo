package com.example.firstProject.demo;

import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController

public class StockItem {

    @Autowired
    private StockRepository stockRepository;

    @PostMapping(path = "/createStock",consumes = "application/json", produces = "application/json")
    public ResponseEntity<GenericResponse> createStock(@RequestBody STOCK_ITEM stock){
        STOCK_ITEM a = stockRepository.findBySkuId(stock.getSkuId());

        //need to ask how to validate duplicate skuid
        if(a == null){
            stock.setCreatedAt(new Date());
            stock.setUpdatedAt(new Date());
            STOCK_ITEM saved = stockRepository.save(stock);
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.setResult("SUCCESS");
            return ResponseEntity.ok().body(genericResponse);
        } else{
            // how to pass validation error message object
            return ResponseEntity.unprocessableEntity().body(null);
        }

    }

    @GetMapping(path = "/getBySkuId/{skuId}")
    public ResponseEntity<STOCK_ITEM> getBySkuId(@PathVariable String skuId){

        STOCK_ITEM a = stockRepository.findBySkuId(skuId);
        return ResponseEntity.ok().body(a);
    }

    @GetMapping(path = "/getStocks")
    public List<STOCK_ITEM> getStocks(){
        List<STOCK_ITEM> list = new ArrayList<STOCK_ITEM>();
        for (STOCK_ITEM stock_item : stockRepository.findAll()) {
            list.add(stock_item);
        }
        return list;
    }

    @PutMapping(path = "/updateStock")
    public String updateStock( @RequestBody STOCK_ITEM stock){
        stock.setCreatedAt(new Date());
        stock.setUpdatedAt(new Date());
        STOCK_ITEM a = stockRepository.save(stock);
        System.out.println(a);
        return "Success";
    }
}

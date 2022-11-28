package com.example.firstProject.demo;



import java.util.Date;
import java.util.Objects;



import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "STOCK_ITEM")
@Data
@EntityListeners(AuditingEntityListener.class)
public class STOCK_ITEM {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    @JsonProperty("id")
    private Integer id;

    @Column(name = "SKU_ID")
    @JsonProperty("skuId")
    private String skuId;

    @Column(name = "DESCRIPTION")
    @JsonProperty("description")
    private String description;

    @Column(name = "PRODUCT_TYPE")
    @JsonProperty("productType")
    private String productType;

    @Column(name = "IN_STOCK_QUANTITY")
    @JsonProperty("inStockQuantity")
    private int inStockQuantity;

    @Column(name = "RESERVED_STOCK_QUANTITY")
    @JsonProperty("reservedStockQuantity")
    private int reservedStockQuantity;

    @Column(name = "POOL_TYPE")
    @JsonProperty("poolType")
    private String poolType;

    @Column(name = "STATUS")
    @JsonProperty("status")
    private String status;

    @Version
    @Column(name = "VERSION")
    @JsonProperty("version")
    private Integer version = 1;

    @Column(name = "CREATED_AT")
    @JsonProperty("createdAt")
    @CreatedDate
    private Date createdAt;

    @Column(name = "CREATED_BY")
    @JsonProperty("createdBy")
    private String createdBy;

    @Column(name = "UPDATED_AT")
    @JsonProperty("updatedAt")
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "UPDATED_BY")
    @JsonProperty("updatedBy")
    private String updatedBy;

    public STOCK_ITEM() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        STOCK_ITEM other = (STOCK_ITEM) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}

package com.capitole.productsapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal

@Table("PRODUCTS")
data class Product(
    @Id
    val sku: String,
    val price: BigDecimal,
    val description: String,
    val category: String
)

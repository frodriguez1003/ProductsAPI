package com.capitole.productsapi.dto

data class ProductDTO(
    val sku: String,
    val price: Double,
    val description: String,
    val category: String
)

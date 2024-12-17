package com.capitole.productsapi.services

import com.capitole.productsapi.dto.ProductDTO

fun interface ProductsService {
    fun findProducts(category: String?, sortBy: String?, page: Int, size: Int): List<ProductDTO>
}

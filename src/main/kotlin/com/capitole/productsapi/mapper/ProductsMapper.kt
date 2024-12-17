package com.capitole.productsapi.mapper

import com.capitole.productsapi.dto.ProductDTO
import com.capitole.productsapi.models.Product
import org.springframework.stereotype.Component

@Component
class ProductsMapper {
    fun mapProducts(products: List<Product>): List<ProductDTO> {
        return products.map { product -> ProductDTO(
            product.sku,
            product.price.toDouble(),
            product.description,
            product.category
        )}
    }
}
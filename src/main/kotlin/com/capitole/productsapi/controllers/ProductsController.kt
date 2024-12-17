package com.capitole.productsapi.controllers

import com.capitole.productsapi.dto.ProductDTO
import com.capitole.productsapi.services.ProductsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsController(private val productsService: ProductsService) {
    @GetMapping("/products")
    fun findProducts(
        @RequestParam(name = "category", defaultValue = "", required = false) category: String,
        @RequestParam(name = "sortBy", defaultValue = "", required = false) sortBy: String,
        @RequestParam(name = "page", defaultValue = "0") page: Int,
        @RequestParam(name = "pageSize", defaultValue = "10") size: Int,
    ): List<ProductDTO> {
        return productsService.findProducts(category, sortBy, page, size);
    }
}

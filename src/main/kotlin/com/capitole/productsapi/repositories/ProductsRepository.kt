package com.capitole.productsapi.repositories

import com.capitole.productsapi.models.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.PagingAndSortingRepository

interface ProductsRepository : PagingAndSortingRepository<Product, String> {

    fun findByCategoryIgnoreCase(category: String, pageable: Pageable): List<Product>

    fun findByCategoryIgnoreCase(category: String, sort: Sort): List<Product>
}
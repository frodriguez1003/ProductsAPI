package com.capitole.productsapi.services

import com.capitole.productsapi.dto.ProductDTO
import com.capitole.productsapi.mapper.ProductsMapper
import com.capitole.productsapi.models.Product
import com.capitole.productsapi.repositories.ProductsRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ProductsServiceImpl(
    private val productsRepository: ProductsRepository,
    private val productsMapper: ProductsMapper
) : ProductsService {

    override fun findProducts(category: String?, sortBy: String?, page: Int, size: Int): List<ProductDTO> {
        val pagination: Pageable = PageRequest.of(page, size)
        val products: List<Product> = when {
            !category.isNullOrEmpty() && !sortBy.isNullOrEmpty() ->
                productsRepository.findByCategoryIgnoreCase(category, (pagination as PageRequest).withSort(Sort.by(sortBy).ascending()))

            !category.isNullOrEmpty() ->
                productsRepository.findByCategoryIgnoreCase(category, pagination)

            !sortBy.isNullOrEmpty() ->
                productsRepository.findAll((pagination as PageRequest).withSort(Sort.by(sortBy).ascending())).toList()

            else ->
                productsRepository.findAll(pagination).toList()
        }

        return productsMapper.mapProducts(products).map { applyDiscounts(it) }
    }

    private fun applyDiscounts(product: ProductDTO): ProductDTO {
        val discount = when {
            product.category.equals("Electronics", ignoreCase = true) -> 0.15
            product.category.equals("Home & Kitchen", ignoreCase = true) -> 0.25
            product.sku.endsWith('5') -> 0.3
            else -> 0.0
        }

        val newPrice = product.price * (1 - discount)
        return product.copy(price = newPrice)
    }
}

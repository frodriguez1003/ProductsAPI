package com.capitole.productsapi.unit

import com.capitole.productsapi.mapper.ProductsMapper
import com.capitole.productsapi.models.Product
import com.capitole.productsapi.repositories.ProductsRepository
import com.capitole.productsapi.services.ProductsServiceImpl
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.math.BigDecimal

class ProductsServiceTest() {

    val productsRepository: ProductsRepository = mockk();
    val productsMapper: ProductsMapper = ProductsMapper();
    var productsService = ProductsServiceImpl(productsRepository, productsMapper);
    var products = arrayListOf<Product>()
    val pagination: Pageable = PageRequest.of(0, 10)

    @BeforeEach
    fun setUp() {
        val product1 =
            Product("SKU0001", BigDecimal.valueOf(19.99), "Wireless Mouse with ergonomic design", "Electronics")
        val product2 = Product("SKU0002", BigDecimal.valueOf(499.00), "4K Ultra HD Smart TV, 55 inches", "Electronics")
        val product3 =
            Product("SKU0026", BigDecimal.valueOf(16.50), "Aromatherapy Essential Oil Diffuser", "Home & Kitchen")
        val product4 =
            Product("SKU0005", BigDecimal.valueOf(120.00), "Noise-Cancelling Over-Ear Headphones", "Electronics")
        products.addAll(listOf(product1, product2, product3, product4))
    }

    @Test
    fun `get products and discount applied`() {
        //GIVEN
        every { productsRepository.findAll(pagination) } returns PageImpl(products)
        //WHEN
        val products = productsService.findProducts("", "", 0, 10);
        //THEN
        assertEquals(4, products.size)
        assertEquals(16.9915, products[0].price)
        assertEquals(424.15, products[1].price)
        assertEquals(12.375, products[2].price)
        assertEquals(102.0, products[3].price)
    }

    @Test
    fun `get products and sort by price and discount applied`() {
        //GIVEN
        every { productsRepository.findAll(pagination.getSortOr(Sort.by("price").ascending())) } returns PageImpl(
            products.sortedBy { it.price })
        //WHEN
        val products = productsService.findProducts("", "price", 0, 10);
        //THEN
        assertEquals(4, products.size)
        assertEquals(12.375, products[0].price)
        assertEquals(16.9915, products[1].price)
        assertEquals(102.0, products[2].price)
        assertEquals(424.15, products[3].price)
    }

    @Test
    fun `get products and sort by description and discount applied`() {
        //GIVEN
        every { productsRepository.findAll(pagination.getSortOr(Sort.by("description"))) } returns products.sortedBy { it.description }
        //WHEN
        val products = productsService.findProducts("", "description", 0, 10);
        //THEN
        assertEquals(4, products.size)
        assertEquals("4K Ultra HD Smart TV, 55 inches", products[0].description)
        assertEquals("Aromatherapy Essential Oil Diffuser", products[1].description)
        assertEquals("Noise-Cancelling Over-Ear Headphones", products[2].description)
        assertEquals("Wireless Mouse with ergonomic design", products[3].description)
    }

    @Test
    fun `get products with type electronics and discount applied`() {
        //GIVEN
        every {
            productsRepository.findByCategoryIgnoreCase(
                "Electronics",
                pagination
            )
        } returns products.filter { product -> product.category.equals("Electronics", ignoreCase = true) }
        //WHEN
        val products = productsService.findProducts("Electronics", "", 0, 10);
        //THEN
        assertEquals(3, products.size)
        assertEquals(16.9915, products[0].price)
        assertEquals(424.15, products[1].price)
        assertEquals(102.0, products[2].price)
    }

    @Test
    fun `get products with type Home & Kitchen and discount applied`() {
        //GIVEN
        every {
            productsRepository.findByCategoryIgnoreCase(
                "Home & Kitchen",
                pagination
            )
        } returns products.filter { product -> product.category.equals("Home & Kitchen", ignoreCase = true) }
        //WHEN
        val products = productsService.findProducts("Home & Kitchen", "", 0, 10);
        //THEN
        assertEquals(1, products.size)
        assertEquals(12.375, products[0].price)
    }

    @Test
    fun `get products with type Electronics and sort by price and discount applied`() {
        //GIVEN
        every {
            productsRepository.findByCategoryIgnoreCase(
                "Electronics",
                pagination.getSortOr(Sort.by("price").ascending())
            )
        } returns products.filter { it.category == "Electronics" }
            .sortedBy { it.price }
        //WHEN
        val products = productsService.findProducts("Electronics", "price", 0, 10);
        //THEN
        assertEquals(3, products.size)
        assertEquals(16.9915, products[0].price)
        assertEquals(102.0, products[1].price)
        assertEquals(424.15, products[2].price)
    }

    @Test
    fun `get products with type Electronics and sort by sku and discount applied`() {
        //GIVEN
        every {
            productsRepository.findByCategoryIgnoreCase(
                "Electronics",
                pagination.getSortOr(Sort.by("sku").ascending())
            )
        } returns products.filter { it.category == "Electronics" }
            .sortedBy { it.sku }
        //WHEN
        val products = productsService.findProducts("Electronics", "sku", 0, 10);
        //THEN
        assertEquals(3, products.size)
        assertEquals("SKU0001", products[0].sku)
        assertEquals("SKU0002", products[1].sku)
        assertEquals("SKU0005", products[2].sku)
    }
}

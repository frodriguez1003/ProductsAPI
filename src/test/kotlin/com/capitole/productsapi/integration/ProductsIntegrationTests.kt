package com.capitole.productsapi.integration

import org.json.JSONArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers

@SpringBootTest
@AutoConfigureMockMvc
@BaseIT
class ProductsIntegrationTests @Autowired constructor(
    val mockMvc: MockMvc
) {

    @Test
    fun `get products with discounts success`() {
        val response = mockMvc.get("/products")
            .andDo { MockMvcResultHandlers.print() }
            .andExpect { status { isOk() } }
        val jsonArray = JSONArray(response.andReturn().response.contentAsString)
        assertEquals(6, jsonArray.length())
        assertEquals("SKU0001", jsonArray.getJSONObject(0).get("sku"))
        assertEquals(16.9915, jsonArray.getJSONObject(0).get("price"))

        assertEquals("SKU0002", jsonArray.getJSONObject(1).get("sku"))
        assertEquals(424.15, jsonArray.getJSONObject(1).get("price"))


        assertEquals("SKU0003", jsonArray.getJSONObject(2).get("sku"))
        assertEquals(22.125, jsonArray.getJSONObject(2).get("price"))


        assertEquals("SKU0004", jsonArray.getJSONObject(3).get("sku"))
        assertEquals(15.0, jsonArray.getJSONObject(3).get("price"))


        assertEquals("SKU0005", jsonArray.getJSONObject(4).get("sku"))
        assertEquals(102.0, jsonArray.getJSONObject(4).get("price"))


        assertEquals("SKU0015", jsonArray.getJSONObject(5).get("sku"))
        assertEquals(29.4, jsonArray.getJSONObject(5).get("price"))
    }

    @Test
    fun `get products with category electronics with discounts success`() {
        val response = mockMvc.get("/products?category=electronics")
            .andDo { MockMvcResultHandlers.print() }
            .andExpect { status { isOk() } }
        val jsonArray = JSONArray(response.andReturn().response.contentAsString)
        assertEquals(3, jsonArray.length())
        assertEquals("SKU0001", jsonArray.getJSONObject(0).get("sku"))
        assertEquals(16.9915, jsonArray.getJSONObject(0).get("price"))

        assertEquals("SKU0002", jsonArray.getJSONObject(1).get("sku"))
        assertEquals(424.15, jsonArray.getJSONObject(1).get("price"))


        assertEquals("SKU0005", jsonArray.getJSONObject(2).get("sku"))
        assertEquals(102.0, jsonArray.getJSONObject(2).get("price"))
    }

    @Test
    fun `get products with category electronics and sort by description with discounts success`() {
        val response = mockMvc.get("/products?category=electronics&sortBy=description")
            .andDo { MockMvcResultHandlers.print() }
            .andExpect { status { isOk() } }
        val jsonArray = JSONArray(response.andReturn().response.contentAsString)
        assertEquals(3, jsonArray.length())
        assertEquals("SKU0002", jsonArray.getJSONObject(0).get("sku"))
        assertEquals("4K Ultra HD Smart TV, 55 inches", jsonArray.getJSONObject(0).get("description"))
        assertEquals(424.15, jsonArray.getJSONObject(0).get("price"))

        assertEquals("SKU0005", jsonArray.getJSONObject(1).get("sku"))
        assertEquals("Noise-Cancelling Over-Ear Headphones", jsonArray.getJSONObject(1).get("description"))
        assertEquals(102.0, jsonArray.getJSONObject(1).get("price"))


        assertEquals("SKU0001", jsonArray.getJSONObject(2).get("sku"))
        assertEquals("Wireless Mouse with ergonomic design", jsonArray.getJSONObject(2).get("description"))
        assertEquals(16.9915, jsonArray.getJSONObject(2).get("price"))
    }
}

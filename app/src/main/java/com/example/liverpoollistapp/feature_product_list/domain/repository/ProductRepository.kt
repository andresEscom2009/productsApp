package com.example.liverpoollistapp.feature_product_list.domain.repository

import com.example.liverpoollistapp.core.util.Resource
import com.example.liverpoollistapp.feature_product_list.domain.model.Products
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(wordSearch: String, sortOption: String): Flow<Resource<Products>>
}
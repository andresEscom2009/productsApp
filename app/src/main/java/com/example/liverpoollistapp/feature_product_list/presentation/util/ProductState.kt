package com.example.liverpoollistapp.feature_product_list.presentation.util

import com.example.liverpoollistapp.feature_product_list.domain.model.Product

data class ProductState(
    val products: List<Product> = emptyList(),
    val loading: Boolean = false
)

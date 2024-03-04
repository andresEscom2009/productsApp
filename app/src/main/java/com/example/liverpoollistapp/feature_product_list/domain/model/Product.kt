package com.example.liverpoollistapp.feature_product_list.domain.model

import androidx.compose.ui.graphics.Color

data class Product(
    val imgProduct: String,
    val productName: String,
    val listPrice: Double,
    val promoPrice: Double,
    val variantColors: List<Color>
)

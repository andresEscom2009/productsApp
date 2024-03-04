package com.example.liverpoollistapp.feature_product_list.data.data_source.remote.dto.productsDto

data class PlpStateDto(
    val area: String,
    val categoryId: String,
    val currentFilters: String,
    val currentSortOption: String,
    val firstRecNum: Int,
    val id: String,
    val lastRecNum: Int,
    val originalSearchTerm: String,
    val plpSellerName: String,
    val recsPerPage: Int,
    val totalNumRecs: Int
)
package com.example.liverpoollistapp.feature_product_list.data.data_source.remote.dto.productsDto

import com.example.liverpoollistapp.feature_product_list.domain.model.Products

data class ProductsDto(
    val nullSearch: String,
    val pageType: String,
    val plpResults: PlpResultsDto,
    val status: StatusDto
){
    fun toProducts(): Products {
        return Products(plpResults.records.map { it.toProduct() })
    }
}
package com.example.liverpoollistapp.feature_product_list.domain.use_cases

import com.example.liverpoollistapp.core.util.Resource
import com.example.liverpoollistapp.feature_product_list.domain.model.Products
import com.example.liverpoollistapp.feature_product_list.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetProducts(
    private val repository: ProductRepository
) {

    operator fun invoke(wordSearch: String, sortOption: String = "Relevancia"): Flow<Resource<Products>> {
        if (wordSearch.isBlank()){
            return flow {  }
        }
        return repository.getProducts(wordSearch, sortOption)
    }
}
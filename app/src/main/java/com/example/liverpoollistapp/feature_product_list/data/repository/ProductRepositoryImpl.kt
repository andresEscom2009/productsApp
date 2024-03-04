package com.example.liverpoollistapp.feature_product_list.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.liverpoollistapp.core.util.Resource
import com.example.liverpoollistapp.feature_product_list.data.data_source.remote.LiverpoolApi
import com.example.liverpoollistapp.feature_product_list.domain.model.Products
import com.example.liverpoollistapp.feature_product_list.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class ProductRepositoryImpl(
    private val api: LiverpoolApi
) : ProductRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getProducts(wordSearch: String, sortOption: String): Flow<Resource<Products>> = flow {
        emit(Resource.Loading())
        try {
            val products = api.getProducts(1, "{{$wordSearch}}", sortOption, false, 40, false)
            if (products.status.statusCode == 0) {
                emit(Resource.Success(products.toProducts()))
            }else{
                emit(Resource.Error(
                    message = "Error: ${products.status.status}"
                ))
            }
        }catch (e: HttpException) {
            emit(Resource.Error(
                message = "Error: ${e.message}"
            ))
        }catch (e: IOException) {
            emit(Resource.Error(
                message = "Error: ${e.localizedMessage}"
            ))
        }
    }
}
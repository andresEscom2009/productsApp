package com.example.liverpoollistapp.feature_product_list.data.data_source.remote

import com.example.liverpoollistapp.feature_product_list.data.data_source.remote.dto.productsDto.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LiverpoolApi {

    //@GET("appclienteservices/services/v7/plp/sf?page-number=1&search-string=%7B%7B{wordSearch}%7D%7D&{sortOption}=&force-plp=false&number-of-items-per-page=40&cleanProductName=false")
    @GET("appclienteservices/services/v7/plp/sf")
    suspend fun getProducts(
        @Query("page-number") pageNumber: Int,
        @Query("search-string") wordSearch: String,
        @Query("sort-option") sortOption: String,
        @Query("force-plp") forcePlp: Boolean,
        @Query("number-of-items-per-page") numberOfItemsPerPage: Int,
        @Query("cleanProductName") cleanProductName: Boolean,
    ): ProductsDto

    companion object {
        const val BASE_URL = "https://shoppapp.liverpool.com.mx/"
    }

}
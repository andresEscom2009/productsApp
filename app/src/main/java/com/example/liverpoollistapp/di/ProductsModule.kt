package com.example.liverpoollistapp.di

import com.example.liverpoollistapp.feature_product_list.data.data_source.remote.LiverpoolApi
import com.example.liverpoollistapp.feature_product_list.data.repository.ProductRepositoryImpl
import com.example.liverpoollistapp.feature_product_list.domain.repository.ProductRepository
import com.example.liverpoollistapp.feature_product_list.domain.use_cases.GetProducts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsModule {

    @Provides
    @Singleton
    fun provideGetProductsUseCase(repository: ProductRepository): GetProducts {
        return GetProducts(repository)
    }

    @Provides
    @Singleton
    fun provideProductsRepository(api: LiverpoolApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideLiverpoolApi(): LiverpoolApi {
        return Retrofit.Builder()
            .baseUrl(LiverpoolApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LiverpoolApi::class.java)
    }
}
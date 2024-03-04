package com.example.liverpoollistapp.feature_product_list.data.data_source.remote.dto.productsDto

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.substring
import com.example.liverpoollistapp.feature_product_list.domain.model.Product

data class RecordDto(
    val ar: Boolean,
    val brand: String,
    val category: String,
    val categoryBreadCrumbs: List<String>,
    val dwPromotionInfo: DwPromotionInfoDto,
    val enableTryOn: Boolean,
    val groupType: String,
    val isHybrid: Boolean,
    val isImportationProduct: Boolean,
    val isMarketPlace: Boolean,
    val lgImage: String,
    val listPrice: Double,
    val maximumListPrice: Double,
    val maximumPromoPrice: Double,
    val minimumListPrice: Double,
    val minimumPromoPrice: Double,
    val productAvgRating: Double,
    val productDisplayName: String,
    val productId: String,
    val productRatingCount: Int,
    val productType: String,
    val promoPrice: Double,
    val promotionalGiftMessage: String,
    val seller: String,
    val skuRepositoryId: String,
    val smImage: String,
    val variantsColor: List<VariantsColorDto>,
    val xlImage: String
) {
    fun toProduct(): Product {
        return Product(
            imgProduct = smImage,
            productName = productDisplayName,
            promoPrice = promoPrice,
            listPrice = listPrice,
            variantColors = variantsColor.map { variantColor ->
                Color(android.graphics.Color.parseColor(variantColor.colorHex))
            }
        )
    }
}
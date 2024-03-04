package com.example.liverpoollistapp.feature_product_list.data.data_source.remote.dto.productsDto

data class PlpResultsDto(
    val enableMinNumOfPieces: Boolean,
    val label: String,
    val plpState: PlpStateDto,
    val records: List<RecordDto>,
    val redirectTo404: Boolean,
    val sortOptions: List<SortOptionDto>
)
package com.example.liverpoollistapp.feature_product_list.presentation.products

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.liverpoollistapp.feature_product_list.domain.model.Product

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            painter = rememberAsyncImagePainter(product.imgProduct),
            contentDescription = "Image product",
            modifier = Modifier
                .size(200.dp)
        )
        Column {
            Text(text = product.productName, style = MaterialTheme.typography.headlineMedium)
            if (product.listPrice != product.promoPrice) {
                Text(text = "$ ${product.listPrice}", style = MaterialTheme.typography.bodyMedium)
            }
            Text(text = "$ ${product.promoPrice}", style = MaterialTheme.typography.bodyMedium, color = Color.Red)
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                horizontalArrangement = Arrangement.Start
            ){
                product.variantColors.forEach { color ->
                    Log.i("Color", "Color: $color")
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .shadow(1.dp, CircleShape)
                            .clip(CircleShape)
                            .background(color)
                            .padding(4.dp)
                    ){

                    }
                }
            }
        }
    }
}
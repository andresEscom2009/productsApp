package com.example.liverpoollistapp.feature_product_list.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liverpoollistapp.core.util.Resource
import com.example.liverpoollistapp.feature_product_list.domain.use_cases.GetProducts
import com.example.liverpoollistapp.feature_product_list.presentation.util.ProductState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
   private val getProducts: GetProducts
) : ViewModel() {

   private val _searchQuery = mutableStateOf("")
   val searchQuery: State<String> = _searchQuery

   private val _state = mutableStateOf(ProductState())
   val state: State<ProductState> = _state

   private val _eventFlow = MutableSharedFlow<UiEvent>()
   val eventFlow = _eventFlow.asSharedFlow()

   private var searchJob: Job? = null


   fun onSearch(query: String) {
      _searchQuery.value = query
      searchJob?.cancel()
      searchJob = viewModelScope.launch {
         delay(300)
         getProducts(query)
            .onEach { result ->
               when(result) {
                  is Resource.Error -> {
                     _state.value = state.value.copy(
                        products = result.data?.products ?: emptyList(),
                        loading = false
                     )
                     _eventFlow.emit(UiEvent.ShowSnackBar(
                        result.message ?: "Error to get the info"
                     ))
                  }
                  is Resource.Loading -> {
                     _state.value = state.value.copy(
                        products = result.data?.products ?: emptyList(),
                        loading = true
                     )
                  }
                  is Resource.Success -> {
                     _state.value = state.value.copy(
                        products = result.data?.products ?: emptyList(),
                        loading = false
                     )
                  }
               }
            }.launchIn(this)
      }
   }

   sealed class UiEvent {
      data class ShowSnackBar(val message: String): UiEvent()
   }

}
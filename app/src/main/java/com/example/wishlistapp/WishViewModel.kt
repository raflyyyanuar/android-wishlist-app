package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.wishlistapp.data.Wish

class WishViewModel : ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChange(newTitle: String) {
        wishTitleState = newTitle
    }

    fun onWishDescriptionChange(newDescription: String) {
        wishDescriptionState = newDescription
    }
}
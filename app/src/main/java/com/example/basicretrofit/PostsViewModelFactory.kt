package com.example.basicretrofit



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PostsViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel (repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
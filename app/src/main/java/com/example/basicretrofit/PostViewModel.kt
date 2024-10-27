package com.example.basicretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val repository: Repository
):ViewModel(){


    val _error= MutableLiveData<String>()
    val error:LiveData<String> get() = _error
    val posts= MutableStateFlow<List<Post>>(emptyList())

    init {
        getPost()
    }
 fun getPost(){
    viewModelScope.launch(Dispatchers.IO) {
        val getPost=repository.getPosts()
        posts.value=getPost
    }

}

}
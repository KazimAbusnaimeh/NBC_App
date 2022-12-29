package com.mycompany.nbcapp.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.mycompany.nbcapp.R
import com.mycompany.nbcapp.models.Page
import com.mycompany.nbcapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NbcViewModel @Inject constructor(
    private val repository: Repository
):androidx.lifecycle.ViewModel() {
    val page: MutableLiveData<Page> = MutableLiveData()

    fun setPage() {
       viewModelScope.launch (Dispatchers.IO){
           page.postValue(repository.getPage())
       }
    }
}
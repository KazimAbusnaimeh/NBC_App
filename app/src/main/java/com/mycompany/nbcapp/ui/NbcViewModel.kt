package com.mycompany.nbcapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mycompany.nbcapp.models.Page
import com.mycompany.nbcapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NbcViewModel @Inject constructor(private val repository: Repository):androidx.lifecycle.ViewModel() {
    val page: MutableLiveData<Page> = MutableLiveData()


    fun setPage() {
       viewModelScope.launch (Dispatchers.IO){
           repository.getPage().enqueue(object : Callback<Page?> {
               override fun onResponse(call: Call<Page?>, response: Response<Page?>) {
                   page.postValue(response.body())
               }

               override fun onFailure(call: Call<Page?>, t: Throwable) {
               }
           })
       }
    }
}
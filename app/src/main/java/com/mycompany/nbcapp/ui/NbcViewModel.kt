package com.mycompany.nbcapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mycompany.nbcapp.models.Page
import com.mycompany.nbcapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NbcViewModel @Inject constructor(
    private val repository: Repository
) : androidx.lifecycle.ViewModel() {
    val page: MutableLiveData<Page> = MutableLiveData()

    fun setPage() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                page.postValue(repository.getPage())
            } catch (e: java.lang.Exception) {
            }
        }
    }
}
package ru.int24.testroom.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.int24.testroom.models.OneCDocument
import ru.int24.testroom.repos.DocumentRepository
import ru.int24.testroom.repos.NetworkRepository
import ru.int24.testroom.repos.UseDataBase

class DocumentViewModel(application: Application): AndroidViewModel(application) {

    var listDoc: MutableLiveData<ArrayList<OneCDocument>> = MutableLiveData()
    private lateinit var repository: DocumentRepository
    private  var networkRepository: NetworkRepository = NetworkRepository()

    init {
        val documentDao = UseDataBase.getInstance(getApplication()).documentDao()
        repository = DocumentRepository(documentDao)

    }


    fun getFromNetwork(){
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO, {networkRepository.GetFromNetwork()})
            //listDoc.value = networkRepository.dataFromNetwork
        }

    }

    fun setTodataBase(){
        for (doc in networkRepository.dataFromNetwork){
            addDocument(doc)
        }
    }

    fun setDocToList(){
        /*viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO, { repository.fetchDocuments() })
            listDoc.value = repository.readAllData
        }*/

    }

    fun addDocument(doc:OneCDocument){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDocument(doc)
        }
    }

    fun getListDoc(): LiveData<ArrayList<OneCDocument>>{
        val myListDoc: LiveData<ArrayList<OneCDocument>> = listDoc
        return myListDoc
    }

}
package ru.int24.testroom.repos

import ru.int24.testroom.interfaces.FetchDocumentFromNetwork
import ru.int24.testroom.models.OneCDocument

class NetworkRepository {

    var dataFromNetwork: ArrayList<OneCDocument> = ArrayList<OneCDocument>()

    suspend fun GetFromNetwork(){
        dataFromNetwork = FetchDocumentFromNetwork.fetchData()
    }



}
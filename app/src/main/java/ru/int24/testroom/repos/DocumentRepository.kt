package ru.int24.testroom.repos

import ru.int24.testroom.interfaces.DocumentDao
import ru.int24.testroom.models.OneCDocument

class DocumentRepository(private val documentDao: DocumentDao) {

    var readAllData: ArrayList<OneCDocument> = ArrayList<OneCDocument>()

    suspend fun fetchDocuments(){
        readAllData = documentDao.readAllData()
    }

    suspend fun addDocument(doc: OneCDocument){
        documentDao.addDocument(doc)
    }
}
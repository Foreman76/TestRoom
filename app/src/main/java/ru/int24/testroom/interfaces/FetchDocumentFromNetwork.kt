package ru.int24.testroom.interfaces

import com.google.gson.Gson
import ru.int24.testroom.models.OneCDocument
import ru.int24.testroom.models.Tovar

interface FetchDocumentFromNetwork {
    companion object{

        //Предположим что получили из сети эти данные

        fun fetchData(): ArrayList<OneCDocument>{

            val listDocument = ArrayList<OneCDocument>()
            val listTovar = ArrayList<Tovar>()
            val myGson: Gson = Gson()


            for (i in 1..5){
                listTovar.add(Tovar(tovarId = i.toString(), tovarName = "Товар "+i.toString()))
            }

            val st: String = myGson.toJson(listTovar)

            for (i in 1..100){
                listDocument.add(OneCDocument(idDoc = i.toString(), dateDoc = "20.03.2020:13.12.01", numberDoc = "00123454", goods = st))
            }

            return listDocument
        }

    }

}
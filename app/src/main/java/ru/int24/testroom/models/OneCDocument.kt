package ru.int24.testroom.models

import androidx.room.Entity
import androidx.room.PrimaryKey



data class Tovar(
    val tovarName:String,
    val tovarId:String
)

@Entity(tableName = "mdoc")
data class DBDocument(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val idDoc:String,
    val dateDoc:String,
    val numberDoc:String,
    val goods:String
)

data class OneCDocument(
    val idDoc:String,
    val dateDoc:String,
    val numberDoc:String,
    val goods:String

)
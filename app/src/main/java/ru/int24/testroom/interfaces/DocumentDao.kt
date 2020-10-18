package ru.int24.testroom.interfaces

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.int24.testroom.models.OneCDocument

interface DocumentDao {

    @Query("SELECT * FROM mdoc order by id")
    fun readAllData(): ArrayList<OneCDocument>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDocument(doc:OneCDocument)

} 